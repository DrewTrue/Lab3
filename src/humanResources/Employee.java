package humanResources;

public abstract class Employee{
    private String firstName;
    private String secondName;
    private JobTitlesEnum jobTitle;
    private int salary;

    protected Employee(String firstName, String secondName,  int salary){
        this(firstName, secondName, JobTitlesEnum.NONE, salary);
    }
    protected Employee(String firstName, String secondName, JobTitlesEnum jobTitle, int salary){
        this.firstName = firstName;
        this.secondName = secondName;
        this.jobTitle = jobTitle;
        this.salary = salary;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getSecondName(){
        return secondName;
    }

    public void setSecondName(String secondName){
        this.secondName = secondName;
    }

    public JobTitlesEnum getJobTitle(){
        return jobTitle;
    }

    public void setJobTitle(JobTitlesEnum jobTitle){
        this.jobTitle = jobTitle;
    }

    public int getSalary(){
        return salary;
    }

    public void setSalary(int salary){
        this.salary = salary;
    }

    public abstract int getBonus();
    public abstract void setBonus(int bonus);

    @Override
    public String toString(){
        /*if(firstName != null && secondName != null && jobTitle != JobTitlesEnum.NONE && salary != 0)
            return firstName + secondName + jobTitle + " " + salary + "р.";*/
        StringBuilder result = new StringBuilder();
        if(firstName != null)
            result.append(firstName).append(" ");
        if(secondName != null)
            result.append(secondName).append(" ");;
        if(jobTitle != JobTitlesEnum.NONE)
            result.append(jobTitle).append(" ");
        if(salary != 0)
            result.append(firstName).append("p. ");
        return result.toString();
    }

    @Override
    public boolean equals(Object obj){
        //Employee employee = (Employee) obj;
        if(this == obj)
            return true;
        if(firstName == ((Employee) obj).firstName
                && secondName == ((Employee) obj).secondName
                && jobTitle == ((Employee) obj).jobTitle
                && salary == ((Employee) obj).salary)
            return true;
        return false;
    }

    @Override
    public int hashCode() {
        int hash = firstName.hashCode() ^ secondName.hashCode() ^ jobTitle.hashCode() ^ salary;
        return hash;
    }
}