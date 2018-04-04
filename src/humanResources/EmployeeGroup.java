package humanResources;

public interface EmployeeGroup {
    void addEmployee(Employee employee);
    Employee[] getEmployeesSortedBySalary();
    Employee[] getEmployees();
    int employeeQuantity();
    boolean removeEmployee(String firstName, String secondName);
    boolean removeEmployee(Employee employee);
    Employee getEmployee(String firstName, String secondName);
    String getName();
    void setName(String name);
    Employee mostValuableEmployee();
    String toString();
    boolean equals(Object obj);
    int hashCode();
}
