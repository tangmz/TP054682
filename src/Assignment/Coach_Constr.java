package Assignment;

public class Coach_Constr {
    private String CoachId, CoachN, CoachTel, CoachHRate, CoachStar, CoachCenter, CoachSp_Id, CoachAdd, JDate, TDate;

    public Coach_Constr(String CoachId, String CoachN, String CoachTel, String CoachHRate, String CoachStar, 
            String CoachCenter, String CoachSp_Id, String CoachAdd, String JDate, String TDate) {
        this.CoachId = CoachId;
        this.CoachN = CoachN;
        this.CoachTel = CoachTel;
        this.CoachHRate = CoachHRate;
        this.CoachStar = CoachStar;
        this.CoachCenter = CoachCenter;
        this.CoachSp_Id = CoachSp_Id;
        this.CoachAdd = CoachAdd;
        this.JDate = JDate;
        this.TDate = TDate;
    }
    
    public String getCoachId() {
        return CoachId;
    }

    public void setCoachId(String CoachId) {
        this.CoachId = CoachId;
    }

    public String getCoachN() {
        return CoachN;
    }

    public void setCoachN(String CoachN) {
        this.CoachN = CoachN;
    }

    public String getCoachTel() {
        return CoachTel;
    }

    public void setCoachTel(String CoachTel) {
        this.CoachTel = CoachTel;
    }

    public String getCoachHRate() {
        return CoachHRate;
    }

    public void setCoachHRate(String CoachHRate) {
        this.CoachHRate = CoachHRate;
    }

    public String getCoachStar() {
        return CoachStar;
    }

    public void setCoachStar(String CoachStar) {
        this.CoachStar = CoachStar;
    }

    public String getCoachCenter() {
        return CoachCenter;
    }

    public void setCoachCenter(String CoachCenter) {
        this.CoachCenter = CoachCenter;
    }

    public String getCoachSp_Id() {
        return CoachSp_Id;
    }

    public void setCoachSp_Id(String CoachSp_Id) {
        this.CoachSp_Id = CoachSp_Id;
    }

    public String getCoachAdd() {
        return CoachAdd;
    }

    public void setCoachAdd(String CoachAdd) {
        this.CoachAdd = CoachAdd;
    }

    public String getJDate() {
        return JDate;
    }

    public void setJDate(String JDate) {
        this.JDate = JDate;
    }

    public String getTDate() {
        return TDate;
    }

    public void setTDate(String TDate) {
        this.TDate = TDate;
    }


}
