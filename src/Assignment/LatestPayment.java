package Assignment;
public class LatestPayment extends AbstractPayment{
    private int totalPayment;  
    public LatestPayment(String a, int c){
        name = a;
        classes = 2;
        totalPayment = c;
    }
    public int getStudentHour(){
        return classes*4;
    }
    public double calTotalPayment(){
        return totalPayment;
    }
    public String toString(){
        return super.toString()+"Your payment is RM"+totalPayment+" this month!\n";
    }
}
