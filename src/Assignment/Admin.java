package Assignment;

public class Admin {
    private String adId, adUserN, adPass, adName, adPlace, adGender, adPhone;

    public Admin(String adId, String adUserN, String adPass, String adName, String adPlace, String adGender, String adPhone) {
        this.adId = adId;
        this.adUserN = adUserN;
        this.adPass = adPass;
        this.adName = adName;
        this.adPlace = adPlace;
        this.adGender = adGender;
        this.adPhone = adPhone;
    }

    public String getAdId() {
        return adId;
    }

    public void setAdId(String adId) {
        this.adId = adId;
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

    public String getAdGender() {
        return adGender;
    }

    public void setAdGender(String adGender) {
        this.adGender = adGender;
    }

    public String getAdPhone() {
        return adPhone;
    }

    public void setAdPhone(String adPhone) {
        this.adPhone = adPhone;
    }
}
