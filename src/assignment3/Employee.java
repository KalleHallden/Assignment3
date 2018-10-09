package assignment3;


public class Employee {

    private String name;
    private final String ID;
    private double grossSalary;
    private double netSalary;
    private double totalSalary;

    public double getTotalSalary() {
        return totalSalary;
    }
    public void setTotalSalary() {
        totalSalary = getGrossSalary();
    }

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
        grossSalary = grossSalary;
        return grossSalary;
    }

    public void setGrossSalary(double grossSalary) {
        this.grossSalary = grossSalary;

    }

    public void setNetSalary() {

        netSalary = grossSalary - (grossSalary * 0.1);

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

    public void printEmployee(){
        System.out.println("ID: " + this.getID());
        System.out.println("Name: " + this.getName());
        System.out.println("Gross salary: " + this.getGrossSalary());
        System.out.println("Net salary: " + this.getNetSalary());
    }
}


