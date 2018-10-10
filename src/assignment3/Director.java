package assignment3;

public class Director extends Manager {
    private String department;
    static double benefit;

    public Director(String name, String ID, double grossSalary, String degree, String department) {
        super(name, ID, grossSalary, degree);
        this.department = department;
    }

    //fixa detta

    @Override
    public double getNetSalary() {
        if (this.getGrossSalary()< 30000) {
            return netSalary = this.getGrossSalary() * 0.90;
        }
        if (this.getGrossSalary() <= 50000 && this.getGrossSalary() >= 30000) {
            return netSalary = this.getGrossSalary() * 0.80;
        }
        if (this.getGrossSalary() > 50000) {
            double newNet = this.getGrossSalary() - 30000;
            newNet = (newNet * 0.6) + (30000 * 0.8);
            return netSalary = newNet;
        } else {
            return 0.0;
        }
    }

    @Override
    public double getGrossSalary() {
        return super.getGrossSalary() + benefit;
    }

    @Override
    public void printEmployee() {
        super.printEmployee();
        this.getGrossSalary();
        System.out.println("This is the directors benefit: " + this.benefit);
        System.out.println("This is the new salary: " + this.getGrossSalary());
    }

}
