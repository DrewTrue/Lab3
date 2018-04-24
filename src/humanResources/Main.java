package humanResources;

import humanResources.*;

public class Main {

    public static void main(String[] args) {
        CircleLinkedList linkedList = new CircleLinkedList();
        BusinessTravel businessTravel1 = new BusinessTravel();
        BusinessTravel businessTravel2 = new BusinessTravel("ad",5,0,"sdf");
        linkedList.addNode(businessTravel1);
        linkedList.addNode(businessTravel2);
        BusinessTravel[] bt = linkedList.getBusinessTravels();
        System.out.println(bt[1].getDaysCount());
        Project project = new Project("asd", new Employee[10]);
        StaffEmployee em = new StaffEmployee("as","asd",JobTitlesEnum.ADMINISTRATOR, 10);
        StaffEmployee ema = new StaffEmployee("asasdf","asad",JobTitlesEnum.ACCOUNTANT, 100);
    }
}
