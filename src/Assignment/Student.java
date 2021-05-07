package Assignment;

public class Student {
    private String stuID;
    private String stuName;
    private String stuUserN;
    private String stuPass;
    private String stuPlace;

    public Student(String stuName, String stuUserN, String stuPass, String stuPlace) {
        this.stuName = stuName;
        this.stuUserN = stuUserN;
        this.stuPass = stuPass;
        this.stuPlace = stuPlace;
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


