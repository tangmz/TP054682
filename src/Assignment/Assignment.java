package Assignment;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Assignment {
    public static Landing login = new Landing();
    public static Register register = new Register();
    public static Visitor visitorView = new Visitor();
    public static RegisteredAdmin registeredAd = new RegisteredAdmin();
    public static RegisteredStudent registeredStu = new RegisteredStudent();
    public static ArrayList <Student> studentInfo = new ArrayList<Student>();
    public static ArrayList<Admin> adminInfo = new ArrayList<Admin>();
    public static Date DateTime;
        
    public static void main(String[] args) {
        try{
            
            Scanner s = new Scanner(new File("studentLogin.txt"));
            while(s.hasNext()){
                int a = Integer.parseInt(s.nextLine());
                String b = s.nextLine();
                String c = s.nextLine();
                String d = s.nextLine();
                String e = s.nextLine();
                String f = s.nextLine();
                String g = s.nextLine();
                s.nextLine();
                Student student = new Student(a,b,c,d,e,f,g);
                studentInfo.add(student);
            }
            s = new Scanner(new File("adminLogin.txt"));
            while(s.hasNext()){
                int h = Integer.parseInt(s.nextLine());
                String i = s.nextLine();
                String j = s.nextLine();
                String k = s.nextLine();
                String l = s.nextLine();
                String m = s.nextLine();
                String n = s.nextLine();
                s.nextLine();
                Admin admin = new Admin(h,i,j,k,l,m,n);
                adminInfo.add(admin);
                //allCustomer.add(c);
            }
        }catch(Exception ex){
            System.out.println("Error Reading Files");
        }
    }
}
