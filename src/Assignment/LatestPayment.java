package Assignment;
//Extend the abstract class and implements the interface which only allow the same method/function name
public class LatestPayment extends AbstractPayment implements TotalPayment{
    //Variable Declaration
    private int totalPayment;  
    public LatestPayment(String a, int c){
        name = a;
        classes = 2;
        totalPayment = c;
    }
    public int getStudentClasses(){
        //Calculate student classes
        return classes*4;
    }
    public int calTotalPayment(){
        //Return the totalPayment of the subscribed sport
        return totalPayment;
    }
    public String toString(){
        //Show user their payment in this month
        return super.toString()+"Your payment is RM"+totalPayment+" this month!\n";
    }
}
