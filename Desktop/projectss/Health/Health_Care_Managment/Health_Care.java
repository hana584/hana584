
package Health_Care_Managment;

import static Health_Care_Managment.load_info.load_dArr;
import java.util.*;
import java.io.*;
import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;


 abstract class patient {
     protected String ID;
     protected  String name;
      protected String address;
      protected String phone_number;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
    public patient(){
     ID=null;
      name=null;
     address=null;
     phone_number=null;
    
    }
    public patient(String ID, String name, String address,String phone_number){ 
     this.ID=ID;
     this.name=name;
     this.address= address;
     this.phone_number=phone_number;
     
 }
    
    //public abstract void edit();
    public abstract void delete(String ID);
     public  ArrayList<emergency_patient> display() throws IOException{
       ArrayList<emergency_patient>patients = null;
        try {
            BufferedReader in = new BufferedReader(new FileReader("emergency patient.txt"));
            String line;
            String[] split;
             patients =new ArrayList<emergency_patient>();
            
while((line = in.readLine())!= null)
{
  split=line.split(" , ");
    patient pa= new emergency_patient(split[0], split[1],split[2],split[3],split[4],split[5],split[6],split[7],split[8]);
    patients.add(   (emergency_patient) pa); 
}
in.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(emergency_patient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(emergency_patient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return patients;
   }
      public  ArrayList<normal_Patient> display_norm() throws IOException{
       ArrayList<normal_Patient>patientss = null;
        try {
            BufferedReader in = new BufferedReader(new FileReader("patient.txt"));
            String line;
            String[] split;
             patientss =new ArrayList<normal_Patient>();
            
while((line = in.readLine())!= null)
{
  split=line.split(" , ");
    patient pa= new normal_Patient(split[0], split[1],split[2],split[3],split[4],split[5],split[6],split[7]);
    patientss.add(   (normal_Patient) pa); 
}
in.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(emergency_patient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(emergency_patient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return patientss;
   }
       public void add(String ID, String Name,String address, String phone_num,String gender,String symptoms,String diagnosis,String payment_method){
//       public void add(String ID, String Name,String address, String phone_num,String gender,String symptoms,String diagnosis,String payment_method){
         
         
       try{
           
            File file= new File("patient.txt");
            if(!file.exists()){
                file.createNewFile();
            }
            PrintWriter pw= new PrintWriter(file);
     pw.printf(ID+",");
              pw.printf(Name+" , ");
               pw.printf(address+" , ");
                pw.printf(phone_num+" , ");

                pw.printf(gender+" , ");
                pw.printf(symptoms+" , ");
                  pw.printf(diagnosis," , ");
                pw.printf(payment_method+" , ");
               pw.close();
       }
    
            
       catch(IOException e){
            e.printStackTrace();
        }
        
  
    
 }
        public void add(String ID, String Name,String address, String phone_num,String gender,String symptoms,String diagnosis,String payment_method,String room_num){
         
         
       try{
           
            File filee= new File("emergency_patient.txt");
            if(!filee.exists()){
                filee.createNewFile();
            }
            PrintWriter pw= new PrintWriter(filee);
            
  
     pw.printf(ID+",");
     
              pw.printf(Name+" , ");
             
               pw.printf(address+" , ");
             
                pw.printf(phone_num+" , ");
            
                pw.printf(gender+" , ");
                pw.printf(symptoms+" , ");
                  pw.printf(diagnosis," , ");
                pw.printf(payment_method+" , ");
                pw.printf(room_num+" , ");
               pw.close();
       }
       catch(IOException e){
            e.printStackTrace();
        }

}
 }
class normal_Patient extends patient{
     protected String gender;
     protected String symptoms;
     protected String diagnosis;
     protected String payment_methods;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getPayment_methods() {
        return payment_methods;
    }

    public void setPayment_methods(String payment_methods) {
        this.payment_methods = payment_methods;
    }
    public normal_Patient(){
     gender=null;
     symptoms=null;
     diagnosis=null;
      payment_methods=null;
    
    
    }
    public normal_Patient(String ID, String name, String address,String phone_number,String gender,String symptoms,String diagnosis,String payment_method){
        super(ID,name,address,phone_number);
        this.gender=gender;
        this.symptoms=symptoms;
        this.diagnosis=diagnosis;
        this.payment_methods=payment_method;
        
    }
   
       
   public void delete( String ID )
 {
   
     try
     {
File tempFile = new File("myTempPatientFile1.txt");

BufferedReader reader = new BufferedReader(new FileReader("patient.txt"));
BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
//String tmpID;
       //  tmpID = reader.readLine(ID);

String lineToRemove = ID ; // hb2a ab3tlo el id ely hamsa7 beh el line 
String currentLine;

while((currentLine = reader.readLine()) != null) {
    // trim newline when comparing with lineToRemove
    String trimmedLine = currentLine.trim();
    if(trimmedLine.equals(lineToRemove)) continue;
    writer.write(currentLine + System.getProperty("line.separator"));
}
writer.close(); 
reader.close(); 
     
//boolean successful = tempFile.renameTo(("patient.txt"));
     }
    catch (IOException ex ) {
        Logger.getLogger(normal_Patient.class.getName()).log(Level.SEVERE, null, ex);
 }  

}
     
  //   @Override
    
}
    

class emergency_patient extends patient{
    protected  String room_number;
protected String gender;
     protected String symptoms;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getPayment_methods() {
        return payment_methods;
    }

    public void setPayment_methods(String payment_methods) {
        this.payment_methods = payment_methods;
    }
     protected String diagnosis;
     protected String payment_methods;
    public String getRoom_number() {
        return room_number;
    }

    public void setRoom_number(String room_number) {
        this.room_number = room_number;
    }
    public emergency_patient()
    
    {
    
     gender=null;
     symptoms=null;
     diagnosis=null;
      payment_methods=null;
      room_number=null;
    
    
    }
    public emergency_patient(String ID, String name, String address,String phone_number,String gender,String symptoms,String diagnosis,String payment_method,String room_number){
    
        super(ID,name,address,phone_number);
         this.gender=gender;
        this.symptoms=symptoms;
        this.diagnosis=diagnosis;
        this.payment_methods=payment_method;
        this.room_number= room_number;  
        
    }
    
    
    
    @Override
    public void delete(  String ID )
 {
   try
     {
File tempFile = new File("emergency_patient.txt");

BufferedReader reader = new BufferedReader(new FileReader("emergency_patient.txt"));
BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
//String tmpID;
       //  tmpID = reader.readLine(ID);

String lineToRemove = ID ; // hb2a ab3tlo el id ely hamsa7 beh el line 
String currentLine;

while((currentLine = reader.readLine()) != null) {
    // trim newline when comparing with lineToRemove
    String trimmedLine = currentLine.trim();
    if(trimmedLine.equals(lineToRemove)) continue;
    writer.write(currentLine + System.getProperty("line.separator"));
}
writer.close(); 
reader.close(); 
     
//boolean successful = tempFile.renameTo(("emergency patient.txt"));
     }
    catch (IOException ex ) {
        Logger.getLogger(emergency_patient.class.getName()).log(Level.SEVERE, null, ex);
 }  

}
 
 
     }
class doctor{ 
    private String ID;
    private String name;
    private String address;
     private String phone_number;
    private String special_medialist;
  private ArrayList<appointment> appoints;

    public ArrayList<appointment> getAppoints() {
        return appoints;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getSpecial_medialist() {
        return special_medialist;
    }

    public void setSpecial_medialist(String special_medialist) {
        this.special_medialist = special_medialist;
    }
    public doctor(){
    ID= null;
      name=null;
      address=null;
     phone_number= null;
     special_medialist=null;
    
    
    }
   public doctor(String ID,String name,String address,String phone_number,String special_medialist){
   this.ID=ID;
   this.name=name;
   this.address=address;
   this.phone_number=phone_number;
   this.special_medialist=special_medialist;
   
   }
   public void add_doctor(String ID, String Name,String address, String phone_num,String special_med ){
       try{
           
            File file= new File("doctorr.txt");
            if(!file.exists()){
                file.createNewFile();
            }
            PrintWriter pw= new PrintWriter(file);
            
   Scanner scan= new Scanner(System.in);
   String choice;

     pw.printf(ID,",");

              pw.printf(name+" , ");

               pw.printf(address+" , ");

                pw.printf(phone_number+" , ");

                pw.printf(special_medialist+" , ");
               pw.close();

       }
       catch(IOException e){
            e.printStackTrace();
        }
 }
  public void delete_doctor(  String ID )
 {          
     try
     {
File tempFile = new File("doctorr.txt");

BufferedReader reader = new BufferedReader(new FileReader("doctorr.txt"));
BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
//String tmpID;
       //  tmpID = reader.readLine(ID);

String lineToRemove = ID ; // hb2a ab3tlo el id ely hamsa7 beh el line 
String currentLine;

while((currentLine = reader.readLine()) != null) {
    // trim newline when comparing with lineToRemove
    String trimmedLine = currentLine.trim();
    if(trimmedLine.equals(lineToRemove)) continue;
    writer.write(currentLine + System.getProperty("line.separator"));
}
writer.close(); 
reader.close(); 
     
//boolean successful = tempFile.renameTo(("doctorr.txt"));
     }
    catch (IOException ex ) {
        Logger.getLogger(doctor.class.getName()).log(Level.SEVERE, null, ex);
 }  
 }
 public  ArrayList<doctor> display_doctor() throws IOException{
            ArrayList<doctor>Doctors =new ArrayList<doctor>();
            String[] split;
        try {
            BufferedReader in = new BufferedReader(new FileReader("doctorr.txt"));
            String line;
while((line = in.readLine())!= null)
{
    split=line.split(" , ");
    doctor d= new doctor(split[0], split[1],split[2],split[3],split[4]);
    Doctors.add(d);
    
}
in.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(emergency_patient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Doctors;
   }         
}
class load_info{
    public static ArrayList<doctor> load_dArr;
    public static ArrayList<normal_Patient> load_npArr;
    public static ArrayList<emergency_patient> load_epArr;
 public static void load_doctor_info(){
      
      try{
          Scanner s= new Scanner(new FileReader("doctorr.txt")).useDelimiter(","); 
         load_dArr=new ArrayList<>();
          while(s.hasNext()){
 String doctor_id=s.next();
   String doctor_name=s.next();
   String doctor_address=s.next();
   String doctor_phone_num=s.next();
    String doctor_special_med=s.next();
     
   
    doctor person=new doctor(doctor_id, doctor_name, doctor_address, doctor_phone_num, doctor_special_med);
load_dArr.add(person);

                   
      }
  } catch(IOException e){
            e.printStackTrace();
        }
 }
 public static void load_normal_patient_info(){
      try{
          Scanner s= new Scanner(new FileReader("patient.txt")).useDelimiter(","); 
           load_npArr=new ArrayList<>();
          while(s.hasNext()){
  String patient_id=s.next();
   String patient_name=s.next();
   String patient_address=s.next();
   String patient_phone_num=s.next();
     String patient_gender=s.next();
   String  patient_sym=s.next();
   String  patient_pay=s.next();
   String  patient_diag=s.next();
  
   
    patient person=new normal_Patient(patient_id, patient_name, patient_address, patient_phone_num, patient_gender, patient_sym,patient_pay, patient_diag);
load_npArr.add((normal_Patient)person);
                   
      }
  } catch(IOException e){
            e.printStackTrace();
        }
}}

class appointment {
  patient p;
  String appoint;
  public appointment(patient p,String appoint)
  {
  this.p=p;
  this.appoint=appoint;
 
  }
  public boolean check(ArrayList<appointment> arr)
  {
  for(int i=0;i<arr.size();i++)
  {
    if (arr.get(i).appoint.equals(this.appoint))
    {
      return false;
    }
  }
  return true;
  }
// static  String[] available_time;
//  public void load_arr(){
//    try{
//           
//            File filee= new File("doctorr.txt");
//            if(!filee.exists()){
//                filee.createNewFile();
//            }
//            PrintWriter pw= new PrintWriter(filee);
//       
//       
//      pw.printf("2019/04/09 10:00"+" , ");
//       pw.printf("2019/04/07 8:30"+" , ");
//        pw.printf("2019/04/20 5:40"+" , ");
//         pw.printf("2019/04/13 2:00"+" , ");
//          pw.printf("2019/04/25 1:30"+" , ");
//           pw.printf("2019/04/30 2:30"+" , ");
//      
//    
//               pw.close();
//       }
//    
//    
////             
//       catch(IOException e){
//            e.printStackTrace();
//        }

////}
////
////
//// 
////       public void time() throws ParseException, IOException{
////     // ArrayList<String> arr= new ArrayList<>();
////       try {
////            BufferedReader in = new BufferedReader(new FileReader("appointment.txt"));
////            String line = in.readLine();
////            available_time=line.split(" , ");
////
////in.close();
////
////
////        } catch (FileNotFoundException ex) {
////            Logger.getLogger(emergency_patient.class.getName()).log(Level.SEVERE, null, ex);
////        }
////       String d="2019/04/11 12:30";
////       
////       Date date=new SimpleDateFormat("yyyy/MM/dd HH:mm").parse(d) ;
////       Date d1=new Date();
////       if(date.getTime()<d1.getTime())
////       {
////           System.out.println("less than");
////       }
////     
////     }
}
       




 

   
    

    
   
//abstract class add_person{
//  
//    String id;
//   String name;
//   String address;
//   String phone_num;
//   String gender;
//   String sym;
//   String special_med;
//   String pay;
//   String diag;
// static  ArrayList< add_person> load_dArr;
// static   ArrayList< add_person> load_pvector;
//  abstract void ad_doctor();
//  abstract void ad_normal_patient();
//   abstract void ad_emergency_patient();
//    abstract void edit_doctor();
//   
// public add_person(  String id,String name,String address,String phone_num){
//  this.id=id;
//  this.name=name;
//  this.address=address;
//  this.phone_num=phone_num;
//}
//}
//
//
// class add_edit_persoon extends add_person{
//       public add_edit_persoon( String id,String name,String address,String phone_num,String special_med){
//     super(id,name,address,phone_num);
//     this.special_med=special_med;
//     
//    }
//     public add_edit_persoon( String id,String name,String address,String phone_num,String gender,String sym,String diag,String pay){
//         super(id,name,address,phone_num);
//         this.gender=gender;
//         this.sym=sym;
//         this.diag=diag;
//         this.pay=pay;
//     }
//     public void ad_doctor(){
// try{
//           
//            File file= new File("doctorr.txt");
//            if(!file.exists()){
//                file.createNewFile();
//            }
//            PrintWriter pw= new PrintWriter(file);
//            
//   Scanner scan= new Scanner(System.in);
//   String choice;
//   do{
//      
//   System.out.println("enter doctor id: ");
//    id= scan.next();
//     pw.printf(id,",");
//    final Scanner scanner = new Scanner(file);
//while (scanner.hasNextLine()) 
//{
//   final String lineFromFile = scanner.nextLine();
//   if(lineFromFile.contains(id)) { 
//       // a match!
//       System.out.println("this id is already found ,try again");
//       break;
//   }
//continue;
//    
//}   
//             System.out.println("enter doctor name: ");
//              name=scan.next();
//              pw.printf(name+" , ");
//              System.out.println("enter doctor address: ");
//              address=scan.next();
//               pw.printf(address+" , ");
//              System.out.println("enter doctor phone number: ");
//              phone_num=scan.next();
//                pw.printf(phone_num+" , ");
//              System.out.println("enter doctor special med: ");
//              special_med=scan.next();
//                pw.printf(special_med+" , ");
//               pw.close();
//               System.out.println("add more doctors ?? yes/no ");
//             choice=scan.next();
//               
//               
// }while(choice.equals("yes"));
//       
//                System.out.println("doctor is added succefully");
//       }
//       catch(IOException e){
//            e.printStackTrace();
//        }
// }
////     Vector<> vec_tor = new Vector<String>(); 
////     vec_tor.add(id);
////     vec_tor.add(name);
////     vec_tor.add(address);
////     vec_tor.add(phone_num);
////     vec_tor.add(special_med);
////     
//     
//     
//
//  public void ad_normal_patient(){
//     
//       try{
//            File file= new File("patient.txt");
//            if(!file.exists()){
//                file.createNewFile();
//            }
//            PrintWriter pw= new PrintWriter(file);
////            
//   Scanner scan= new Scanner(System.in);
//    String choice;
//   do{
//   System.out.println("enter patient id: ");
//    id= scan.next();
//    pw.printf(id+",");
//     final Scanner scanner = new Scanner(file);
//while (scanner.hasNextLine()) 
//{
//   final String lineFromFile = scanner.nextLine();
//   if(lineFromFile.contains(id)) { 
//       // a match!
//       System.out.println("this id is already found ,try again");
//       break;
//   }
//continue;
//}
//             System.out.println("enter patient name: ");
//              String patient_name=scan.next();
//               pw.printf( patient_name+",");
//              System.out.println("enter patient address: ");
//              String patient_address=scan.next();
//               pw.printf(patient_address+",");
//               System.out.println("enter patient phone number: ");
//                String patient_phone_num=scan.next();
//                pw.print( patient_phone_num+",");
//               System.out.println("enter patient gender: ");
//                String patient_gender=scan.next();
//                pw.printf(patient_gender+" ");
//                 System.out.println("enter patient symptoms: ");
//                  String patient_symptoms=scan.next();
//                   pw.print( patient_symptoms+",");
//                  System.out.println("enter way of payment: ");
//                   String wayOfPayment=scan.next();
//                    pw.printf( wayOfPayment+",");
//                   System.out.println("enter patient diagnosis: ");
//                    String patient_diagnosis=scan.next();
//                     pw.printf(patient_diagnosis+",");
//                pw.close();
//                System.out.println("normal patient is added succefully");
//                 System.out.println("add more doctors ?? yes/no ");
//             choice=scan.next();
//                }while(choice.equals("yes"));
//       }
//       catch(IOException e){
//            e.printStackTrace();
//        }
////     Vector<String> vec_tor = new Vector<String>(); 
////     vec_tor.add(id);
////     vec_tor.add(name);
////     vec_tor.add(address);
////     vec_tor.add(phone_num);
////     vec_tor.add(special_med);
//     
//  }
//  public void ad_emergency_patient(){
//       try{
//            File file= new File("emergency patient.txt");
//            if(!file.exists()){
//                file.createNewFile();
//            }
//            PrintWriter pw= new PrintWriter(file);
//            
//   Scanner scan= new Scanner(System.in);
//   String choice;
//   do{
//   System.out.println("enter patient id: ");
//    String id= scan.next();
//    pw.print(id);
//     final Scanner scanner = new Scanner(file);
//while (scanner.hasNextLine()) 
//{
//   final String lineFromFile = scanner.nextLine();
//   if(lineFromFile.contains(id)) { 
//       // a match!
//       System.out.println("this id is already found ,try again");
//       break;
//   }
//
//}
//             System.out.println("enter patient name: ");
//              String Epatient_name=scan.next();
//               pw.printf(Epatient_name," , ");
//              System.out.println("enter patient address: ");
//              String Epatient_address=scan.next();
//               pw.printf(Epatient_address," , ");
//               System.out.println("enter patient phone number: ");
//                String Epatient_phone_num=scan.next();
//                pw.printf(Epatient_phone_num," , ");
//               System.out.println("enter patient gender: ");
//                String Epatient_gender=scan.next();
//                pw.printf(Epatient_gender," , ");
//                 System.out.println("enter patient symptoms: ");
//                  String Epatient_symptoms=scan.next();
//                  pw.printf(Epatient_symptoms," , ");
//                  System.out.println("enter way of payment: ");
//                   String EwayOfPayment=scan.next();
//                    pw.printf( EwayOfPayment," , ");
//                   System.out.println("enter patient diagnosis: ");
//                    String Epatient_diagnosis=scan.next();
//                    pw.printf( Epatient_diagnosis," , ");
//                pw.close();
//                System.out.println("emergency patient is added succefully");
//                System.out.println("add more doctors ?? yes/no ");
//             choice=scan.next();
//                }while(choice.equals("yes"));
//       }
//       catch(IOException e){
//            e.printStackTrace();
//        }
//}
//  public static void load_doctor_info(){
//      try{
//          Scanner s= new Scanner(new FileReader("doctorr.txt")).useDelimiter(","); 
//         // load_dvector=new ArrayList<>();
//          while(s.hasNext()){
// String doctor_id=s.next();
//   String doctor_name=s.next();
//   String doctor_address=s.next();
//   String doctor_phone_num=s.next();
//    String doctor_special_med=s.next();
//     
//   
//    add_person person=new add_edit_persoon(doctor_id, doctor_name, doctor_address, doctor_phone_num, doctor_special_med);
//load_dArr.add(person);
//
//                   
//      }
//  } catch(IOException e){
//            e.printStackTrace();
//        }
// }
// 
// public static void load_patient_info(){
//      try{
//          Scanner s= new Scanner(new FileReader("patient.txt")).useDelimiter(","); 
//           load_pvector=new ArrayList<add_person>();
//          while(s.hasNext()){
//  String patient_id=s.next();
//   String patient_name=s.next();
//   String patient_address=s.next();
//   String patient_phone_num=s.next();
//     String patient_gender=s.next();
//   String  patient_sym=s.next();
//   String  patient_pay=s.next();
//   String  patient_diag=s.next();
//  
//   
//    add_person person=new add_edit_persoon(patient_id, patient_name, patient_address, patient_phone_num, patient_gender);
//load_pvector.add(person);
//                   
//      }
//  } catch(IOException e){
//            e.printStackTrace();
//        }
// }
//  public void edit_doctor()
//  {
//       boolean found=false;
//     
//      System.out.println("please enter your ID");
//  Scanner scan = new Scanner(System.in);
//       String id= scan.next();
//          //load_doctor_info();
//       for(int i=0;i<load_dArr.size();i++){
//          
//           if(load_dArr.get(i).id.equals(id)){
//               found=true;
//               //System.out.println(" edit done");  
//               break;
//           }
//           else
//               System.out.println("not valid");
//       }
//       
//       if(found)
//         System.out.println(" edit done");  
//     else
//          System.out.println(" not done");  
//           
//       if(load_dvector.contains(id)){
//       found=true;
//       System.out.print(name+phone_num+special_med);
//       }
//       else
//           System.out.print("not valid");
//String lineContents=null;
//int counter=0;
// try{
//       BufferedReader br=new BufferedReader(new FileReader("doctorr.txt"));
//       while((lineContents=br.readLine())!=null){
//      d_vector.add(lineContents);
//       counter++;
//       }
//}
//catch(FileNotFoundException fne){
//fne.printStackTrace();
//}
//catch(IOException io){
//io.printStackTrace();
//}
 
      
              
       
 
 
//     Vector<String> vec_tor = new Vector<String>(); 
//     vec_tor.add(id);
//     vec_tor.add(name);
//     vec_tor.add(address);
//     vec_tor.add(phone_num);
//     vec_tor.add(special_med);
//     
  
 
//       boolean found = d_vector.contains(id);
//       if(found){
//       System.out.println("done");    
//       }
//
//  else
//           
//    System.out.println("no");    
//                
////for (int i=0;i<lineArray.size();i++){
////System.out.println(lineArray.get(i));
////}
//
//  }
 

 
//class edit_dp_person extends add_person{
//    public edit_dp_person( String id,String name,String address,String phone_num,String special_med){
//   super(id,name,address,phone_num);
//   this.special_med=special_med;
//   
//   
//    }
//     public edit_dp_person( String id,String name,String address,String phone_num,String gender,String sym,String diag,String pay){
//         super(id,name,address,phone_num);
//         this.gender=gender;
//         this.sym=sym;
//         this.diag=diag;
//         this.pay=pay;
//     }
//    
//             public static void load_doctor_info(){
//      try{
//          Scanner s= new Scanner(new FileReader("doctorr.txt")).useDelimiter(","); 
//          Vector load_vector=new Vector();
//          while(s.hasNext()){
//  String doctor_id=s.next();
//   String doctor_name=s.next();
//   String doctor_address=s.next();
//   String doctor_phone_num=s.next();
//    String doctor_special_med=s.next();
//     
//   
//    add_person person=new add_doctor(doctor_id, doctor_name, doctor_address, doctor_phone_num, doctor_special_med);
//load_vector.add(person);
//                   
//      }
//  } catch(IOException e){
//            e.printStackTrace();
//        }
// }
// 
// public static void load_patient_info(){
//      try{
//          Scanner s= new Scanner(new FileReader("patient.txt")).useDelimiter(","); 
//          Vector load_vector=new Vector();
//          while(s.hasNext()){
//  String patient_id=s.next();
//   String patient_name=s.next();
//   String patient_address=s.next();
//   String patient_phone_num=s.next();
//     String patient_gender=s.next();
//   String  patient_sym=s.next();
//   String  patient_pay=s.next();
//   String  patient_diag=s.next();
//  
//   
//    add_person person=new add_persoon(patient_id, patient_name, patient_address, patient_phone_num, patient_gender);
//load_vector.add(person);
//                   
//      }
//  } catch(IOException e){
//            e.printStackTrace();
//        }
// }
// public void edit_doctor(){
//     
// }
//}
//    

public class Health_Care {

    
    public static void main(String[] args) {
//     patient p= new normal_Patient("12", "fg", "fg", "fgh", "tyr", "rtt", "ty", "we");
//     p.add();
//     p.display();
    // doctor d= new doctor("hana", "123", "d5fg", "fgg", "fty");
    // d.add_doctor(, String Name,String address, String phone_num,String special_med ); 
    // d.delete_doctor("12");
    //  public void time() throws ParseException{
//       patient p= new emergency_patient();
//       p.add("12", "3fd","3fd", "3fd","3fd", "3fd", "3fd", "3fd", "3fdsl");
       
      
     
   
    
      }}
    
    

