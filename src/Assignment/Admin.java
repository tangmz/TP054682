package Assignment;

public class Admin {
    private String adUserN, adPass, adName, adPlace;

    public Admin(String adUserN, String adPass, String adName, String adPlace) {
        this.adUserN = adUserN;
        this.adPass = adPass;
        this.adName = adName;
        this.adPlace = adPlace;
    }

    public String getAdUserN() {
        return adUserN;
    }

    public void setAdUserN(String adUserN) {
        this.adUserN = adUserN;
    }

    public String getAdPass() {
        return adPass;
    }

    public void setAdPass(String adPass) {
        this.adPass = adPass;
    }

    public String getAdName() {
        return adName;
    }

    public void setAdName(String adName) {
        this.adName = adName;
    }

    public String getAdPlace() {
        return adPlace;
    }

    public void setAdPlace(String adPlace) {
        this.adPlace = adPlace;
    }
    
}
