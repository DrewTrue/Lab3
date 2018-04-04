package humanResources;

public class StaffEmployee extends Employee implements BusinessTraveller{
    private int bonus;
    private CircleLinkedList list;
    private int travelsQuantity;

    public StaffEmployee(String firstName, String secondName){
        this(firstName, secondName, JobTitlesEnum.NONE, 0, new CircleLinkedList<>());
    }

    public StaffEmployee(String firstName, String secondName, JobTitlesEnum jobTitles, int salary){
        this(firstName,secondName,jobTitles,salary, new CircleLinkedList<>());
    }

    public StaffEmployee(String firstName, String secondName, JobTitlesEnum jobTitle, int salary, CircleLinkedList list){
        super(firstName, secondName, jobTitle, salary);
        this.list = list;
        this.bonus = 0;
        this.travelsQuantity = 0;
    }

    @Override
    public void addTravel(BusinessTravel travel) {
        list.addNode(travel);
        travelsQuantity++;
    }

    @Override
    public BusinessTravel[] getTravel(){
        return list.getBusinessTravels();
    }

    public int getTravelsQuantity(){
        return travelsQuantity;
    }

    public int getBonus(){
        return bonus;
    }

    public void setBonus(int bonus){
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        //String s = super.toString() + "\n" + "Travels  \n";
        result.append(super.toString()).append("\n").append("Travels ").append("/n");
        BusinessTravel[] businessTravel = list.getBusinessTravels();
        for(int i = 0; i < businessTravel.length; i++){
            //s += businessTravel[i].toString() + "\n";
            result.append(businessTravel[i].toString()).append("\n");
        }
        return result.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj instanceof StaffEmployee
                && super.equals(obj)
                && this.bonus == ((StaffEmployee) obj).bonus
                && travelsQuantity == ((StaffEmployee) obj).travelsQuantity) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return travelsQuantity ^ bonus ^ list.hashCode();
    }
}
