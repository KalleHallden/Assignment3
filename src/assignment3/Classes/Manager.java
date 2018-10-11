package assignment3.Classes;

import assignment3.Classes.Employee;

public class Manager extends Employee {

    private String degree;
    private double bonus;

    final static public double BACHELOR_PERCENT_BONUS = 1.10;

    final static public double MASTER_PERCENT_BONUS = 1.20;

    final static public double PHD_PERCENT_BONUS = 1.35;

    final static public double TEN_PERCENT_TAX = 0.9;

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
            this.bonus = BACHELOR_PERCENT_BONUS;
        }
        if (degree.equalsIgnoreCase("MSc")) {
            this.bonus = MASTER_PERCENT_BONUS;
        }
        if (degree.equalsIgnoreCase("Phd")) {
            this.bonus = PHD_PERCENT_BONUS;
        }
    }

    @Override
    public double getNetSalary() {
        return netSalary = (super.getGrossSalary() * bonus) * TEN_PERCENT_TAX;
    }

    public Manager(String name, String ID, double grossSalary, String degree) {
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