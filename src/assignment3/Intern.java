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
    public double getGrossSalary() {

        if (this.gpa <= 5) {
            return 0.0;
         }
         if (this.gpa > 5 && this.gpa < 8) {
            return super.getGrossSalary();
         } if (this.gpa >= 8) {
            return super.getGrossSalary() + 1000;
        } else {
             return grossSalary;
        }
    }

    @Override
    public double getNetSalary() {
        return this.getGrossSalary() * 0.9;
    }


    @Override
    public void printEmployee() {
        super.printEmployee();
        System.out.println("This is the interns GPA: " + this.getGpa());
    }
}
