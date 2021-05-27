package Assignment;
//Encapsulation for the Subscription
public class Subscription_Constr {
    private String subscriptionName, subscriptionLocation, coachID, subscriptionSport, subscriptionFee, rating, feedback;
    //Constructor for the Subscription
    public Subscription_Constr(String subscriptionName, String subscriptionLocation, String coachID, String subscriptionSport, String subscriptionFee, String rating, String feedback) {
        this.subscriptionName = subscriptionName;
        this.subscriptionLocation = subscriptionLocation;
        this.coachID = coachID;
        this.subscriptionSport = subscriptionSport;
        this.subscriptionFee = subscriptionFee;
        this.rating = rating;
        this.feedback = feedback;
    }
    //Getter and setter for the subscription
    public String getSubscriptionName() {
        return subscriptionName;
    }

    public void setSubscriptionName(String subscriptionName) {
        this.subscriptionName = subscriptionName;
    }

    public String getSubscriptionLocation() {
        return subscriptionLocation;
    }

    public void setSubscriptionLocation(String subscriptionLocation) {
        this.subscriptionLocation = subscriptionLocation;
    }

    public String getCoachID() {
        return coachID;
    }

    public void setCoachID(String coachID) {
        this.coachID = coachID;
    }

    public String getSubscriptionSport() {
        return subscriptionSport;
    }

    public void setSubscriptionSport(String subscriptionSport) {
        this.subscriptionSport = subscriptionSport;
    }

    public String getSubscriptionFee() {
        return subscriptionFee;
    }

    public void setSubscriptionFee(String subscriptionFee) {
        this.subscriptionFee = subscriptionFee;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

}
