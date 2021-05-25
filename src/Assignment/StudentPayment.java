package Assignment;
public class StudentPayment {
    private String studentName, sportName, studentLocation, studentTotalPayment, studentBalance, studentAttendance;

    public StudentPayment(String studentName, String sportName, String studentLocation, String studentTotalPayment, String studentBalance, String studentAttendance) {
        this.studentName = studentName;
        this.sportName = sportName;
        this.studentLocation = studentLocation;
        this.studentTotalPayment = studentTotalPayment;
        this.studentBalance = studentBalance;
        this.studentAttendance = studentAttendance;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    public String getStudentLocation() {
        return studentLocation;
    }

    public void setStudentLocation(String studentLocation) {
        this.studentLocation = studentLocation;
    }

    public String getStudentTotalPayment() {
        return studentTotalPayment;
    }

    public void setStudentTotalPayment(String studentTotalPayment) {
        this.studentTotalPayment = studentTotalPayment;
    }

    public String getStudentBalance() {
        return studentBalance;
    }

    public void setStudentBalance(String studentBalance) {
        this.studentBalance = studentBalance;
    }

    public String getStudentAttendance() {
        return studentAttendance;
    }

    public void setStudentAttendance(String studentAttendance) {
        this.studentAttendance = studentAttendance;
    }


}
