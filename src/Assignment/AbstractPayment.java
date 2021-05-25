package Assignment;
public abstract class AbstractPayment  {
    protected String name;//Student name
    protected int classes; //Student class hour per month
    public abstract int getStudentHour();
    public String toString(){
        return name+", Your total classes are "+getStudentHour()+"\n";
    }
}
