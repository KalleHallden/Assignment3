package assignment3.Classes;


public class Employee {

    private String name;
    private final String ID;
    public double grossSalary;
    protected double netSalary;

    final static public double TEN_PERCENT_TAX = 0.9;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public double getGrossSalary() {
        return grossSalary;
    }

    public void setGrossSalary(double grossSalary) {
        this.grossSalary = grossSalary;

    }

    public void setNetSalary() {
        netSalary = grossSalary * TEN_PERCENT_TAX;
    }

    public double getNetSalary() {
        return netSalary;
    }


    //HAS TO BE RETRIEVED

    public Employee(String name, String ID, double grossSalary) {

        this.name = name;
        this.ID = ID;
        this.grossSalary = grossSalary;

    }

    public void printEmployee() {
        System.out.println("ID: " + this.getID());
        System.out.println("Name: " + this.getName());
        System.out.println("Gross salary: " + this.grossSalary);
        System.out.println("Net salary: " + this.getNetSalary());
    }
}


