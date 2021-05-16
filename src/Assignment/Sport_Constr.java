package Assignment;

public class Sport_Constr {
    private String SprtId, SportN, Center, CoachN;

    public Sport_Constr(String SprtId, String SportN, String Center, String CoachN) {
        this.SprtId = SprtId;
        this.SportN = SportN;
        this.Center = Center;
        this.CoachN = CoachN;
    }

    public String getSprtId() {
        return SprtId;
    }

    public void setSprtId(String SprtId) {
        this.SprtId = SprtId;
    }

    public String getSportN() {
        return SportN;
    }

    public void setSportN(String SportN) {
        this.SportN = SportN;
    }

    public String getCenter() {
        return Center;
    }

    public void setCenter(String Center) {
        this.Center = Center;
    }

    public String getCoachN() {
        return CoachN;
    }

    public void setCoachN(String CoachN) {
        this.CoachN = CoachN;
    }
}
