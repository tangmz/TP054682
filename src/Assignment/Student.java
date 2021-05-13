package Assignment;

public class Student {
    private int stuID;
    private String stuName, stuUserN, stuPass, stuPlace, stuGender, stuPhone;

    public Student(int stuID, String stuName, String stuUserN, String stuPass, String stuPlace, String stuGender, String stuPhone) {
        this.stuID = stuID;
        this.stuName = stuName;
        this.stuUserN = stuUserN;
        this.stuPass = stuPass;
        this.stuPlace = stuPlace;
        this.stuGender = stuGender;
        this.stuPhone = stuPhone;
    }



    public int getStuID() {
        return stuID;
    }

    public void setStuID(int stuID) {
        this.stuID = stuID;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuUserN() {
        return stuUserN;
    }

    public void setStuUserN(String stuUserN) {
        this.stuUserN = stuUserN;
    }

    public String getStuPass() {
        return stuPass;
    }

    public void setStuPass(String stuPass) {
        this.stuPass = stuPass;
    }

    public String getStuPlace() {
        return stuPlace;
    }

    public void setStuPlace(String stuPlace) {
        this.stuPlace = stuPlace;
    }

    public String getStuGender() {
        return stuGender;
    }

    public void setStuGender(String stuGender) {
        this.stuGender = stuGender;
    }

    public String getStuPhone() {
        return stuPhone;
    }

    public void setStuPhone(String stuPhone) {
        this.stuPhone = stuPhone;
    }
}


