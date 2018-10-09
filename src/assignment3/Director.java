package assignment3;

public class Director extends Manager {
    private String department;
    static double benefit;
    private double directorSalary;

    public Director(String name, String ID, double grossSalary, String degree, String department) {
        super(name, ID, grossSalary, degree);
        this.department = department;
    }

    //fixa detta
    public void setDirectorSalary() {
        directorSalary = getBonus() + benefit;
    }
    public double getDirectorSalary() {
        return directorSalary;
    }

    @Override
    public void printEmployee() {
        super.printEmployee();
        setDirectorSalary();
        System.out.println("This is the directors benefit: " + this.benefit);
        System.out.println("This is the new salary: " + this.getDirectorSalary());
    }

    @Override
    public double getTotalSalary() {
        return directorSalary + benefit;
    }

}
