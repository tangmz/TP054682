package Assignment;
public abstract class AbstractPayment  {
    protected String name;//Student name
    protected int classes; //Student class hour per month
    public abstract int getStudentClasses(); 
    public String toString(){ 
        //Show user that they left how many classes
        return name+", Your total classes are "+getStudentClasses()+"\n";
    }
}
