using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;

namespace Text_AutoCompelet
{
    class Word
    {

        public string word_name;
        public long word_wieght;
        public int distance = 0;

        public static List<Word> uploading()
        {
            int dectinary_size = 0;
            List<Word> dectionary = new List<Word>();
            FileStream fs = new FileStream("[2]Data.txt", FileMode.Open);
            StreamReader reade = new StreamReader(fs);
            while (reade.Peek() != -1)
            {
                string word = reade.ReadLine();
                char[] p = { ' ' };
                string[] words = word.Split(p, 2, StringSplitOptions.RemoveEmptyEntries);
                if (words.Length == 1)
                    dectinary_size = int.Parse(words[0]);
                else if (words.Length == 2)
                {
                    Word temp = new Word();
                    temp.word_wieght = long.Parse(words[0]);
                    temp.word_name = words[1];
                    dectionary.Add(temp);

                }


            }
            reade.Close();
            fs.Close();
            return dectionary;

        }
        public static void writing(List<Word> dectionary)
        {
            FileStream fe = new FileStream("output.txt", FileMode.Append);
            StreamWriter rwiter = new StreamWriter(fe);
            rwiter.WriteLine(dectionary.Count);
            for (int i = 0; i < dectionary.Count; i++)
            {

                rwiter.WriteLine(dectionary[i].word_name);

            }
            rwiter.Close();
            fe.Close();


        }
        public static bool prefix(Word file_query, string the_query)
        {

            if (file_query.word_name.StartsWith(the_query))
            {
                return true;

            }

            return false;

        }
        public static List<Word> merge_sort(List<Word> array)
        {
            if (array.Count <= 1)
                return array;
            List<Word> Left = new List<Word>();
            List<Word> Right = new List<Word>();
            int mid = array.Count / 2;
            for (int i = 0; i < mid; i++)
            {
                Left.Add(array[i]);
            }
            for (int j = mid; j < array.Count; j++)
            {
                Right.Add(array[j]);
            }
            Left = merge_sort(Left);
            Right = merge_sort(Right);
            return merge(Left, Right);
        }
        public static List<Word> merge(List<Word> left, List<Word> right)
        {
            List<Word> result = new List<Word>();
            while (left.Count > 0 || right.Count > 0)
            {
                if (left.Count > 0 && right.Count > 0)
                {
                    if (left.First().distance < right.First().distance)
                    {
                        result.Add(left.First());
                        left.Remove(left.First());
                    }
                    else if (right.First().distance < left.First().distance)
                    {
                        result.Add(right.First());
                        right.Remove(right.First());
                    }
                    else
                    {
                        if (right.First().word_wieght >= left.First().word_wieght)
                        {
                            result.Add(right.First());
                            right.Remove(right.First());
                        }
                        else
                        {
                            result.Add(left.First());
                            left.Remove(left.First());
                        }
                    }
                }
                else if (left.Count > 0)
                {
                    result.Add(left.First());
                    left.Remove(left.First());
                }
                else if (right.Count > 0)
                {
                    result.Add(right.First());
                    right.Remove(right.First());
                }

            }
            return result;

        }
        public int Edit_Distance(string file_query, string the_query)
        {
            int[,] arr = new int[the_query.Length + 1, file_query.Length + 1];
            for (int i = 0; i < the_query.Length + 1; i++)
                for (int j = 0; j < file_query.Length + 1; j++)
                {

                    if (i == 0)
                    {
                        arr[i, j] = j;
                    }
                    else if (j == 0)
                    {
                        arr[i, j] = i;
                    }
                    else if (the_query[i - 1] == file_query[j - 1])
                    {
                        arr[i, j] = arr[i - 1, j - 1];
                    }
                    else
                    {
                        int delet = arr[i - 1, j] + 1;
                        int replace = arr[i - 1, j - 1] + 1;
                        int insert = arr[i, j - 1] + 1;
                        int minmum = Math.Min(delet, replace);
                        arr[i, j] = Math.Min(minmum, insert);
                    }
                }

            distance = arr[the_query.Length, file_query.Length];
            return distance;
        }
        public List<Word> Auto_Comp(string the_query)
        {
            List<Word> dectionary = new List<Word>();
            dectionary = Word.uploading();
           // string the_query;
           // the_query = Console.ReadLine();
            List<Word> prefix_list = new List<Word>();
            List<Word> sorted_list = new List<Word>();
            bool is_p = false;
            for (int i = 0; i < dectionary.Count; i++)
            {
                if (Word.prefix(dectionary[i], the_query))
                {
                    prefix_list.Add(dectionary[i]);
                    is_p = true;
                }


            }

            if (is_p == false)
            {
                for (int i = 0; i < dectionary.Count; i++)
                {
                    dectionary[i].Edit_Distance(dectionary[i].word_name, the_query);

                }
                sorted_list = Word.merge_sort(dectionary);
                int o = 0;
                while (sorted_list[o].distance <= sorted_list[0].distance)
                {
                   // Console.WriteLine(sorted_list[o].distance + " " + sorted_list[o].word_name + " " + sorted_list[o].word_wieght);
                    o++;
                }
               
                Word.writing(sorted_list);
                return sorted_list;
            }
            else
            {
                prefix_list = Word.merge_sort(prefix_list);
                for (int i = 0; i < prefix_list.Count; i++)
                    //  Console.WriteLine(prefix_list[i].word_name + " " + prefix_list[i].word_wieght);
                    //Console.WriteLine(prefix_list.Count);
                   
                Word.writing(prefix_list);
                return prefix_list;
            }

        }
    }
}
