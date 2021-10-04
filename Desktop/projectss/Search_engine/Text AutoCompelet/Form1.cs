using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.IO;

namespace Text_AutoCompelet
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
        }

        private void button1_Click(object sender, EventArgs e)
        {

        }

        private void listView1_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void button1_Click_1(object sender, EventArgs e)
        {
            
            //string text = MainText.Text;
            //List<Word> output = new List<Word>();
            //Word w = new Word();
            //output = w.Auto_Comp(text);
            //for(int i=0;i<output.Count;i++)
            //{
            //    l.Items.Add(output[i].word_wieght);
            //    l.Items.Add(output[i].word_name);   
                
            //}
            
         
        }

        private void l_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void MainText_TextChanged(object sender, EventArgs e)
        {

            string text = MainText.Text;
            List<Word> output = new List<Word>();
            Word w = new Word();
            output = w.Auto_Comp(text);
           
            AutoCompleteStringCollection col = new AutoCompleteStringCollection();
            
            //MainText.AutoCompleteCustomSource = col;
            for (int i = 0; i <= output.Count-1; i++)
            {
                // l.Items.Add(output[i].word_wieght);
                // l.Items.Add(output[i].word_name);
                String str = output[i].word_name.ToString()+" "+ output[i].word_wieght;
                col.Add(str);
               // col.Add(output[i].word_name.ToString());

               
              
            }
            MainText.AutoCompleteCustomSource = col;
            MainText.AutoCompleteMode = AutoCompleteMode.Suggest;
            MainText.AutoCompleteSource = AutoCompleteSource.CustomSource;

        }
    }
}
