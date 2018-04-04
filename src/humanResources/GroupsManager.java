package humanResources;

public interface GroupsManager {
    int employeesQuantity();
    int groupsQuantity();
    void add(EmployeeGroup groupable);
    EmployeeGroup getEmployeeGroup(String name);
    EmployeeGroup[] getEmployeesGroups();
    int employeesQuantity(JobTitlesEnum jobTitle);
    EmployeeGroup getEmployeesGroup(String firstName, String secondName);
    Employee mostValuableEmployee();
    boolean remove(String groupName);
    int remove(EmployeeGroup group);
}
