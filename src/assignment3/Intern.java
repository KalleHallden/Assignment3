package assignment3;

public class Intern extends Employee {

    private int gpa;

    public int getGpa() {
        return gpa;
    }

    public void setGpa(int gpa) {
        this.gpa = gpa;
    }

    public Intern(String name, String ID, double grossSalary, int gpa) {
        super(name, ID, grossSalary);
        this.gpa = gpa;
    }

    @Override
    public void printEmployee() {
        super.printEmployee();
        System.out.println("This is the interns GPA: " + this.getGpa());
    }
}
