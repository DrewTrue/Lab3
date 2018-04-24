package humanResources;

public final class BusinessTravel {
    private int compensation;
    private int daysCount;
    private String description;
    private String destination;
    
    private final static String DEFAULT_LINE = "";
    private final static int DEFAULT_VALUE = 0;

    public BusinessTravel(){
        this(DEFAULT_LINE, DEFAULT_VALUE, DEFAULT_VALUE, DEFAULT_LINE);
    }

    public BusinessTravel(String destination, int daysCount, int compensation, String description){
        this.compensation = compensation;
        this.daysCount = daysCount;
        this.description = description;
        this.destination = destination;
    }

    public int getCompensation(){
        return compensation;
    }

    public int getDaysCount(){
        return daysCount;
    }

    public String getDescription(){
        return description;
    }

    public String getDestination(){
        return destination;
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        result.append(compensation).append(" ").append(daysCount).append(" ").append(description).append(" ").append(destination);
        return result.toString();
    }

    @Override
    public boolean equals(Object obj){
        if( obj instanceof BusinessTravel
                && compensation == ((BusinessTravel) obj).compensation
                && daysCount == ((BusinessTravel) obj).daysCount
                && description == ((BusinessTravel) obj).description
                && destination == ((BusinessTravel) obj).destination) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = compensation ^ daysCount ^ destination.hashCode() ^ description.hashCode();
        return hash;
    }
}
