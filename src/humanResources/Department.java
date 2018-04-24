package humanResources;

public class Department implements EmployeeGroup{
    private String name;
    private int size;
    private Employee[] employees;

    private final static int DEFAULT_SIZE = 8;

    public Department(String name) {
        this(name, DEFAULT_SIZE);
    }

    public Department(String name, int size) {
        this(name, new Employee[size]);
    }

    public Department(String name, Employee[] employees) {
        this.size = employees.length;
        this.name = name;
        this.employees = employees;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getSize(){
        return size;
    }

    public Employee[] getEmployees() {
        Employee[] employees = new Employee[size];
        System.arraycopy(this.employees,0,employees,0,size);
        return employees;
    }

    public Employee[] getEmployees(String jobTitle) {
        int counter = 0;
        for (int i = 0; i < size; i++) {
            if (employees[i] != null && employees[i].getJobTitle().equals(jobTitle))
                counter++;
        }
        Employee[] employee = new Employee[counter];
        counter = 0;
        for (int i = 0; i < size; i++) {
            if (employees[i] != null && employees[i].getJobTitle().equals(jobTitle)) {
                System.arraycopy(employees, i, employee, counter, 1);
                counter++;
            }
        }
        return employee;
    }

    public Employee getEmployee(String firstName, String secondName){
        for(int i = 0; i < size; i++){
            if(employees[i].getFirstName().equals(firstName) && employees[i].getSecondName().equals(secondName))
                return employees[i];
        }
        return null;
    }

    public Employee mostValuableEmployee(){
        return getEmployeesSortedBySalary()[0];
    }

    public Employee[] businessTravellers(){
        int counter = 0;

        StaffEmployee[] employees = new StaffEmployee[size];
        System.arraycopy(this.employees, 0, employees,0, size);

        for(int i = 0; i < size; i++){
            if(employees[i].getTravelsQuantity() != 0)
                counter++;
        }
        Employee[] employee = new Employee[counter];
        counter = 0;
        for(int i = 0; i < size; i++){
            if(employees[i].getTravelsQuantity() != 0) {
                //System.arraycopy(employees, i, employee, counter, 1);
                employee[counter] = employees[i];
                counter++;
            }
        }
        return employee;
    }

    public JobTitlesEnum[] jobTitles(){
        JobTitlesEnum[] jobTitlesEnum = new JobTitlesEnum[JobTitlesEnum.values().length];
        int counter = 0;
        for(int i = 0; i < JobTitlesEnum.values().length; i++){
            for(int j = 0; j < size; j++){
                if(employees[j].getJobTitle().equals(JobTitlesEnum.values()[i])) {
                    jobTitlesEnum[counter] = JobTitlesEnum.values()[i];
                    counter++;
                    break;
                }
            }
        }
        return jobTitlesEnum;
    }

    public boolean removeEmployee(Employee employee) {
        for (int i = 0; i < size; i++) {
            if (employees[i].equals(employee)) {
                if (i < employees.length - 1)
                    System.arraycopy(employees, i + 1, employees, i, size - i - 1);
                employees[size - 1] = null;
                size--;
                return true;
            }
        }
        return false;
    }

    public int removeAll(JobTitlesEnum jobTitle){
        int counter = 0;
        Employee[] employees = new Employee[this.employees.length];
        for (int i = 0; i < size; i++) {
            if(!this.employees[i].getJobTitle().equals(jobTitle)){
                //System.arraycopy(employees, i, employee, counter, 1);
                employees[counter] = this.employees[i];
                counter++;
            }
        }
        size = counter;
        this.employees = employees;
        return size - counter;
    }

    public Employee[] getEmployees(JobTitlesEnum jobTitle) {
        int counter = 0;
        for(int i = 0; i < size; i++){
            if(employees[i].getJobTitle().equals(jobTitle))
                counter++;
        }
        Employee[] employee = new Employee[counter];
        counter = 0;
        for(int i = 0; i < size; i++){
            if(employees[i].getJobTitle().equals(jobTitle)) {
                System.arraycopy(employees, i, employee, counter,1);
                counter++;
            }
        }
        return employee;
    }

    public int employeeQuantity() {
        return size;
    }

    public Employee[] getEmployeesSortedBySalary() {
        Employee[] employees = this.employees;
        if(size > 1) {
            quickSort(employees, 0, size - 1);
            return employees;
        }
        return employees;
    }

    private void swapEmployee(Employee[] employees, int i, int j) {
        Employee template = employees[i];
        employees[i] = employees[j];
        employees[j] = template;
    }

    private void quickSort(Employee[] employees, int begin, int end) {
        int i = begin, j = end, pivot = employees[(begin + end) / 2].getSalary();
        do {
            while (employees[i].getSalary() > pivot && i < end) i++;
            while (employees[j].getSalary() < pivot && j > begin) j--;
            if (i <= j) {
                swapEmployee(employees, i, j);
                i++;
                j--;
            }
        }
        while (i <= j);
        if (begin < j) quickSort(employees, begin, j);
        if (i < end) quickSort(employees, i, end);
    }

    public boolean removeEmployee(String firstName, String secondName) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getFirstName().equals(firstName) && employees[i].getSecondName().equals(secondName)) {
                if (i < employees.length - 1)
                    System.arraycopy(employees, i + 1, employees, i, size - i - 1);
                employees[size - 1] = null;
                size--;
                return true;
            }
        }
        return false;
    }

    public void addEmployee(Employee employee) {
        if(employee == null)
            return;
        if (size == employees.length) {
            StaffEmployee[] employees = new StaffEmployee[this.employees.length * 2];
            System.arraycopy(this.employees,0,employees,0,size);
            this.employees = employees;
        }
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = (StaffEmployee) employee;
                size++;
                break;
            }
        }
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        result.append("Department ").append(name).append(": ").append(size).append("\n");
        //String s = "Department " + name + ": " + size + "\n";
        for(int i = 0; i < size; i++){
            //s += employees[i].toString() + "\n";
            result.append(employees[i].toString()).append("\n");
        }
        return result.toString();
    }

    @Override
    public int hashCode() {
        //return name.hashCode() ^ size ^ employees.hashCode();
        int result = name.hashCode() ^ size;
        for(int i = 0; i < size; i++){
            result ^= employees[i].hashCode();
        }
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj instanceof Department && name == ((Department) obj).name && size == ((Department) obj).size) {
            Employee[] employee = getEmployees();
            Employee[] employeeObject = ((Department) obj).getEmployees();
            for(int i = 0; i < size; i++) {
                if(employee[i].equals(employeeObject[i]))
                    /*.getFirstName().equals(employeeObject[i].getFirstName())
                        && employee[i].getSecondName().equals(employeeObject[i].getSecondName())
                        && employee[i].getJobTitle().equals(employeeObject[i].getJobTitle())
                        && employee[i].getSalary() == employeeObject[i].getSalary()){*/
                    return true;
                }
            }
        return false;
    }
}