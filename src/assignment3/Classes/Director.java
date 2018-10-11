package assignment3.Classes;

public class Director extends Manager {
    private String department;
    public static double benefit;

    final static public double LOW_SALARY = 30000;

    final static public double MEDIUM_SALARY = 50000;

    final static public double TEN_PERCENT_TAX = 0.9;

    final static public double TWENTY_PERCENT_TAX = 0.8;

    final static public double FORTY_PERCENT_TAX = 0.6;

    final static public double NOTHING = 0.0;



    public Director(String name, String ID, double grossSalary, String degree, String department) {
        super(name, ID, grossSalary, degree);
        this.department = department;
    }

    @Override
    public double getNetSalary() {
        if (this.getGrossSalary()< LOW_SALARY) {
            return netSalary = this.getGrossSalary() * TEN_PERCENT_TAX ;
        }
        if (this.getGrossSalary() <= MEDIUM_SALARY && this.getGrossSalary() >= LOW_SALARY) {
            return netSalary = this.getGrossSalary() * TWENTY_PERCENT_TAX;
        }
        if (this.getGrossSalary() > MEDIUM_SALARY) {
            double newNet = this.getGrossSalary() - LOW_SALARY;
            newNet = (newNet * FORTY_PERCENT_TAX) + (MEDIUM_SALARY * TWENTY_PERCENT_TAX);
            return netSalary = newNet;
        } else {
            return NOTHING;
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
        System.out.println("This is the directors benefit: " + benefit);
        System.out.println("This is the new salary: " + this.getGrossSalary());
        System.out.println("This is department: " + this.department);
    }

}
