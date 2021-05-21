package Assignment;
public class Subscription_Constr {
    private String subscriptionName, subscriptionLocation, subscriptionSport, subscriptionFee, feedback;

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

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Subscription_Constr(String subscriptionName, String subscriptionLocation, String subscriptionSport, String subscriptionFee, String feedback) {
        this.subscriptionName = subscriptionName;
        this.subscriptionLocation = subscriptionLocation;
        this.subscriptionSport = subscriptionSport;
        this.subscriptionFee = subscriptionFee;
        this.feedback = feedback;
    }

}
