package Assignment;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Assignment {
    //To call the different class/panel
    public static Landing login = new Landing();
    public static Register register = new Register();
    public static Visitor visitorView = new Visitor();
    public static RegisteredAdmin registeredAd = new RegisteredAdmin();
    public static RegisteredStudent registeredStu = new RegisteredStudent();
    //ArrayList to store the data from the file
    public static ArrayList <Student> studentInfo = new ArrayList<Student>();
    public static ArrayList<Admin> adminInfo = new ArrayList<Admin>();
    public static ArrayList <Coach_Constr> coachInfo = new ArrayList<Coach_Constr>();
    public static ArrayList <Sport_Constr> sportInfo = new ArrayList<Sport_Constr>();
    public static ArrayList<Schedule_Constr> schedule = new ArrayList<Schedule_Constr>();
    public static ArrayList<Subscription_Constr> subscription = new ArrayList<Subscription_Constr>();
    public static ArrayList<StudentPayment> payment = new ArrayList<StudentPayment>();
    public static ArrayList<VisitorAnnouncement> noti = new ArrayList<VisitorAnnouncement>();
    //To extract date from DateTime class
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
            //Coach Info
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
                String c11 = s.nextLine();
                s.nextLine();
                Coach_Constr coach = new Coach_Constr(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11);
                coachInfo.add(coach);
            }
            //Sport Info
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
            //Schedule Info
            s = new Scanner(new File("schedule.txt"));
            while(s.hasNext()){
                String sc1 = s.nextLine();
                String sc2 = s.nextLine();
                String sc3 = s.nextLine();
                String sc4 = s.nextLine();
                String sc5 = s.nextLine();
                String sc6 = s.nextLine();
                String sc7 = s.nextLine();
                String sc8 = s.nextLine();
                String sc9 = s.nextLine();
                String sc10 = s.nextLine();
                String sc11 = s.nextLine();
                String sc12 = s.nextLine();
                String sc13 = s.nextLine();
                String sc14 = s.nextLine();
                String sc15 = s.nextLine();
                String sc16 = s.nextLine();
                String sc17 = s.nextLine();
                String sc18 = s.nextLine();
                String sc19 = s.nextLine();
                String sc20 = s.nextLine();
                String sc21 = s.nextLine();
                String sc22 = s.nextLine();
                String sc23 = s.nextLine();
                s.nextLine();
                Schedule_Constr schedule_read = new Schedule_Constr(sc1,sc2,sc3,sc4,sc5,sc6,sc7,sc8,sc9,sc10,sc11,sc12,sc13,sc14,sc15,sc16,sc17,sc18,sc19,sc20,sc21,sc22,sc23);
                schedule.add(schedule_read);
            }
            //Sport has subscribed by student
            s = new Scanner(new File("subscriptionSport.txt"));
            while(s.hasNext()){
                String d1 = s.nextLine();
                String d2 = s.nextLine();
                String d3 = s.nextLine();
                String d4 = s.nextLine();
                String d5 = s.nextLine();
                String d6 = s.nextLine();
                String d7 = s.nextLine();
                s.nextLine();
                Subscription_Constr sub = new Subscription_Constr(d1,d2,d3,d4,d5,d6,d7);
                subscription.add(sub);
            }
            //Student payment detail
            s = new Scanner(new File("studentPayment.txt"));
            while(s.hasNext()){
                String e1 = s.nextLine();
                String e2 = s.nextLine();
                String e3 = s.nextLine();
                String e4 = s.nextLine();
                String e5 = s.nextLine();
                String e6 = s.nextLine();
                s.nextLine();
                StudentPayment studentPayment = new StudentPayment(e1,e2,e3,e4,e5,e6);
                payment.add(studentPayment);
            }
            //Announcement that has been set by admin
            s = new Scanner(new File("announcement.txt"));
            while(s.hasNext()){
                String f1 = s.nextLine();
                String f2 = s.nextLine();
                s.nextLine();
                VisitorAnnouncement notification = new VisitorAnnouncement(f1,f2);
                noti.add(notification);
            }
        }catch(Exception ex){
            System.out.println("Error Reading Files");
        }
    }
}
