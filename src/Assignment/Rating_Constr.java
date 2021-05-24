package Assignment;

import java.util.ArrayList;

public class Rating_Constr {
    private String coachId;
    private ArrayList<Integer> ratings;

    public Rating_Constr(String coachId, ArrayList<Integer> ratings) {
        this.coachId = coachId;
        this.ratings = ratings;
    }
    
    public String getCoachId() {
        return coachId;
    }

    public void setCoachId(String coachId) {
        this.coachId = coachId;
    }

    public ArrayList<Integer> getRatings() {
        return ratings;
    }

    public void setRatings(ArrayList<Integer> ratings) {
        this.ratings = ratings;
    }
}
