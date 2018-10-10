package assignment3;

public class Manager extends Employee {

    private String degree;
    private double bonus;

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public double getBonus() {
        return this.getGrossSalary() * bonus;
    }

    @Override
    public double getGrossSalary() {
        return super.getGrossSalary() * bonus;
    }

    public void setBonus() {
        if (degree.equalsIgnoreCase("BSc")) {
            this.bonus = 1.1;
        }
        if (degree.equalsIgnoreCase("MSc")) {
            this.bonus = 1.2;
        }
        if (degree.equalsIgnoreCase("Phd")) {
            this.bonus = 1.35;
        }
    }

    @Override
    public double getNetSalary() {
        return netSalary = (super.getGrossSalary() * bonus) * 0.9;
    }

    public Manager(String name, String ID, double grossSalary, String degree){
        super(name, ID, grossSalary);
        this.degree = degree;
        this.bonus = bonus;
    }

    @Override
    public void printEmployee() {
        super.printEmployee();
        System.out.println("Degree: " + this.degree);
        System.out.println("Bonus: " + this.bonus);
        System.out.println("New gross salary: " + this.getGrossSalary());
    }
}