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
    public static ArrayList <Coach_Constr> coachInfo = new ArrayList<Coach_Constr>();
    public static ArrayList <Sport_Constr> sportInfo = new ArrayList<Sport_Constr>();
    public static ArrayList<Admin> adminInfo = new ArrayList<Admin>();
    public static Date DateTime = new Date();
        
    public static void main(String[] args) {
        try{ 
            //Student Login Info
            Scanner s = new Scanner(new File("studentLogin.txt"));
            while(s.hasNext()){
                String a = s.nextLine();
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
            //Admin Login Info
            s = new Scanner(new File("adminLogin.txt"));
            while(s.hasNext()){
                String h = s.nextLine();
                String i = s.nextLine();
                String j = s.nextLine();
                String k = s.nextLine();
                String l = s.nextLine();
                String m = s.nextLine();
                String n = s.nextLine();
                String o = s.nextLine();
                s.nextLine();
                Admin admin = new Admin(h,i,j,k,l,m,n,o);
                adminInfo.add(admin);
            }
            s = new Scanner(new File("coach.txt"));
            while(s.hasNext()){
                String c1 = s.nextLine();
                String c2 = s.nextLine();
                String c3 = s.nextLine();
                String c4 = s.nextLine();
                String c5 = s.nextLine();
                String c6 = s.nextLine();
                String c7 = s.nextLine();
                String c8 = s.nextLine();
                String c9 = s.nextLine();
                String c10 = s.nextLine();
                s.nextLine();
                Coach_Constr coach = new Coach_Constr(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10);
                coachInfo.add(coach);
            }
            s = new Scanner(new File("sport.txt"));
            while(s.hasNext()){
                String d1 = s.nextLine();
                String d2 = s.nextLine();
                String d3 = s.nextLine();
                String d4 = s.nextLine();
                s.nextLine();
                Sport_Constr coach = new Sport_Constr(d1,d2,d3,d4);
                sportInfo.add(coach);
            }
        }catch(Exception ex){
            System.out.println("Error Reading Files");
        }
    }
}
