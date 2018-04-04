package humanResources;

public class PartTimeEmployee extends Employee {

    public PartTimeEmployee(String firstName, String secondName,  int salary){
        this(firstName, secondName, JobTitlesEnum.NONE, salary);
    }

    public PartTimeEmployee(String firstName, String secondName, JobTitlesEnum jobTitle, int salary){
        super(firstName, secondName, jobTitle, salary);
    }

    public int getBonus(){
        return 0;
    }

    public void setBonus(int bonus){ }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        if(super.getFirstName() != null)
            result.append(super.getFirstName()).append(" ");
        if(super.getSecondName() != null)
            result.append(super.getSecondName()).append(" ");
        if(super.getJobTitle() != JobTitlesEnum.NONE)
            result.append(super.getJobTitle()).append("(Внешний совместитель) ");
        if(super.getSalary() != 0)
            result.append(super.getSalary()).append("p.");
        return result.toString();
    }

    @Override
    public boolean equals(Object obj){
        //PartTimeEmployee employee = (PartTimeEmployee) obj;
        if(this == obj)
            return true;
        if(obj instanceof PartTimeEmployee && super.equals(obj)
                /*&& super.getFirstName() == ((PartTimeEmployee) obj).getFirstName()
                && super.getSecondName() == ((PartTimeEmployee) obj).getSecondName()
                && super.getJobTitle() == ((PartTimeEmployee) obj).getJobTitle()
                && super.getSalary() == ((PartTimeEmployee) obj).getSalary()*/ ){
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.getFirstName().hashCode()
                ^ super.getSecondName().hashCode()
                ^ super.getJobTitle().hashCode()
                ^ super.getSalary();
    }
}
