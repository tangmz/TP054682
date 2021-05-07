package Assignment;

public class Student {
    private int stuID;
    private String stuName;
    private String stuUserN;
    private String stuPass;
    private String stuPlace;

    public Student(int stuID, String stuName, String stuUserN, String stuPass, String stuPlace) {
        this.stuID = stuID;
        this.stuName = stuName;
        this.stuUserN = stuUserN;
        this.stuPass = stuPass;
        this.stuPlace = stuPlace;
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
}


