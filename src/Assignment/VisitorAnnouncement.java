package Assignment;

public class VisitorAnnouncement {
    private String cenLocation, Message;

    public VisitorAnnouncement(String cenLocation, String Message) {
        this.cenLocation = cenLocation;
        this.Message = Message;
    }

    public String getCenLocation() {
        return cenLocation;
    }

    public void setCenLocation(String cenLocation) {
        this.cenLocation = cenLocation;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }
    
}
