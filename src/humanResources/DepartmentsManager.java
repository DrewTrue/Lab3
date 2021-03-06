package humanResources;

public class DepartmentsManager implements GroupsManager{
    private String name;
    private EmployeeGroup[] groups;
    private int size;
    private final static int DEFAULT_SIZE = 8;

    public DepartmentsManager(String name) {
        this(name, new EmployeeGroup[DEFAULT_SIZE]);
    }

    public DepartmentsManager(String name, EmployeeGroup[] groups) {
        this.size = groups.length;
        this.name = name;
        this.groups = groups;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    @Override
    public EmployeeGroup[] getEmployeesGroups() {
        EmployeeGroup[] group = new EmployeeGroup[size];
        System.arraycopy(this.groups, 0, group,0, size);
        return group;
    }

    @Override
    public int groupsQuantity() {
        return size;
    }

    @Override
    public EmployeeGroup getEmployeeGroup(String name) {
        for (int i = 0; i < size; i++) {
            if (groups[i] != null & groups[i].getName().equals(name))
                return groups[i];
        }
        return null;
    }

    @Override
    public Employee mostValuableEmployee() {
        int maxSalary = 0, index = 0;
        Employee[] employee;
        for (int i = 0; i < size; i++) {
            if (groups[i] != null) {
                employee = groups[i].getEmployeesSortedBySalary();
                if (employee[0] != null & employee[0].getSalary() > maxSalary) {
                    maxSalary = employee[0].getSalary();
                    index = i;
                }
            }
        }
        employee = groups[index].getEmployeesSortedBySalary();
        return employee[0];
    }

    @Override
    public EmployeeGroup getEmployeesGroup(String firstName, String secondName) {
        Employee[] employee;
        for (int i = 0; i < size; i++) {
            if (groups[i] != null) {
                employee = groups[i].getEmployees();
                for(int j = 0; j < employee.length; j++) {
                    if (employee[j] != null & (employee[j].getFirstName().equals(firstName)
                            && employee[j].getSecondName().equals(secondName)))
                        return groups[i];
                }
            }
        }
        return null;
    }

    @Override
    public int employeesQuantity(JobTitlesEnum jobTitle) {
        int quantity = 0;
        for (int i = 0; i < size; i++) {
            if(groups[i] != null) {
                for(int j = 0; j < groups[i].getEmployees().length; j++){
                    if(groups[i].getEmployees()[j].getJobTitle().equals(jobTitle))
                        quantity++;
                }
                //quantity += groups[i].getEmployees(jobTitle).length;
            }
        }
        return quantity;
    }

    @Override
    public int employeesQuantity() {
        int quantity = 0;
        for (int i = 0; i < size; i++) {
            if(groups[i] != null) {
                quantity += groups[i].getEmployees().length;//getSize
            }
        }
        return quantity;
    }

    @Override
    public void add(EmployeeGroup group) {
        if(group == null)
            return;
        if (size == groups.length) {
            EmployeeGroup[] groups = new EmployeeGroup[this.groups.length * 2];
            System.arraycopy(this.groups, 0, groups,0, size);
            this.groups = groups;
        }
        for (int i = 0; i < groups.length; i++) {
            if (groups[i] == null) {
                groups[i] = group;
                size++;
                break;
            }
        }
    }

    @Override
    public boolean remove(String name) {
        for (int i = 0; i < size; i++) {
            if (groups[i] != null & groups[i].getName().equals(name)) {
                if(i < groups.length - 1)
                    System.arraycopy(groups, i + 1, groups, i, size - i - 1);
                groups[size - 1] = null;
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public int remove(EmployeeGroup group) {
        int counter = 0;
        for (int i = 0; i < size; i++) {
            if (groups[i] != null && groups[i].equals(group)) {
                if(i < groups.length - 1)
                    System.arraycopy(groups, i + 1, groups, i, size - i - 1);
                groups[size - 1] = null;
                size--;
                counter++;
            }
        }
        return counter;
    }
}
