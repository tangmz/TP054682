package Assignment;
public enum Location {
    Center1("Petaling Jaya"), Center2("Bukit Jalil"), Center3("Putrajaya"), Center4("Shah Alam");
    
    private final String location;
    
    Location(final String location){
        this.location = location;
    }
    
    public String toString(){
        return location;
    }
}
