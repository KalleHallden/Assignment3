package assignment3.Classes;

public class Intern extends Employee {

    private final static double GPA_BONUS = 1000;

    private final static double TEN_PERCENT_TAX = 0.9;

    private int gpa;

    private int getGpa() {
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
    public double getGrossSalary() {

        if (this.gpa <= 5) {
            return 0.0;
        }
        if (this.gpa < 8) {
            return super.getGrossSalary();
        }
        if (this.gpa >= 10) {
            return super.getGrossSalary() + GPA_BONUS;
        } else {
            return grossSalary;
        }
    }

    @Override
    public double getNetSalary() {
        return this.getGrossSalary() * TEN_PERCENT_TAX;
    }


    @Override
    public void printEmployee() {
        super.printEmployee();
        System.out.println("This is the interns GPA: " + this.getGpa());
    }
}
