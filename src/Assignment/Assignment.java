package Assignment;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Assignment {
    public static Landing login = new Landing();
    public static Register register = new Register();
    public static Admin whoAdminLogin = null;
    public static Student whoStudentLogin = null;
    public static ArrayList <Student> studentInfo = new ArrayList<Student>();
    public static ArrayList<Admin> adminInfo = new ArrayList<Admin>();
        
    public static void main(String[] args) {
        try{
            
            Scanner s = new Scanner(new File("studentLogin.txt"));
            while(s.hasNext()){
                int a = s.nextInt();
                String b = s.nextLine();
                String c = s.nextLine();
                String d = s.nextLine();
                String e = s.nextLine();
                s.nextLine();
                Student student = new Student(a,b,c,d, e);
                studentInfo.add(student);
            }
            s = new Scanner(new File("adminLogin.txt"));
            while(s.hasNext()){
                String a = s.nextLine();
                String b = s.nextLine();
                String c = s.nextLine();
                String d = s.nextLine();
                s.nextLine();
                Admin admin = new Admin(a,b,c,d);
                adminInfo.add(admin);
                //allCustomer.add(c);
            }
        }catch(Exception ex){
            System.out.println("Error Reading Files");
        }
    }
}
