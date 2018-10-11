package assignment3;

import java.util.Scanner;
import java.util.ArrayList;


public class ReusaxCorp {


    //private double assets; //for calculating expenses and so on?

    private Scanner input = new Scanner(System.in);

    static ArrayList<Employee> employees;
    private IOclass ioRef = new IOclass();

    // private ArrayList<Manager> managers;

    // private ArrayList<Director> directors;

    // private HashMap<String, ArrayList<Employee>> allEmployees;


    public ReusaxCorp() {
        this.employees = new ArrayList<>();

        // this.managers = new ArrayList<>();

        // this.allEmployees = new HashMap<>();

        // this.directors = new ArrayList<>();


    }


    public void registerEmployee() {
        Employee employee;
        String type = ioRef.employeeType();
        if (type != null) {
            String ID = ioRef.createID(type);
            String name = ioRef.createName(type);
            if (name != null) {
                double grossSalary = ioRef.createSalary(type);



                if (type.equalsIgnoreCase("manager")) {
                    createManager(name, ID, grossSalary, type);
                }
                if (type.equalsIgnoreCase("director")) {
                    createDirector(name, ID, grossSalary, type);
                }
                if (type.equalsIgnoreCase("employee")) {
                    employee = new Employee(name, ID, grossSalary);
                    employee.setNetSalary();
                    employees.add(employee);
                }
                if (type.equalsIgnoreCase("intern")) {
                    createIntern(name, ID, grossSalary);
                }
            }
        }
    }

    public void createIntern(String name, String ID, double grossSalary) {
        int gpa = ioRef.createGPA();
        Intern intern = new Intern(name, ID, grossSalary, gpa);
        intern.setNetSalary();
        intern.setGrossSalary(grossSalary);
        employees.add(intern);
    }

    public void createManager(String name, String ID, double grossalary, String type) {
        String degree = ioRef.createDegree(type);
        Manager manager = new Manager(name, ID, grossalary, degree);
        manager.setBonus();
        manager.setNetSalary();
        employees.add(manager);
    }

    public void createDirector(String name, String ID, double grossalary, String type) {
        String degree = ioRef.createDegree(type);
        String department = ioRef.createDepartment(type);

        Director director = new Director(name, ID, grossalary, degree, department);
        director.setBonus();
        director.setNetSalary();
        employees.add(director);

    }

    public void removeEmployee() {

        employees.remove(retrieveEmployee());
    }

    public Employee retrieveEmployee() {

        System.out.println("Please enter the ID of the employee you want to use: ");
        String ID = input.nextLine();

        if (employees.size() > 0) {
            for (int i = 0; i < employees.size(); i++) {

                if (employees.get(i).getID().equals(ID)) {
                    employees.get(i).printEmployee();
                    return employees.get(i);
                } else {
                    System.out.println("An employee of ID " + ID + " is not registered in the system.");
                    return null;
                }
            }
        } else {
            System.out.println("No employees registered");
            return null;
        }
        return null;
    }

    public void printAllEmployees() {
        if (employees.size() > 0) {
            for (int i = 0; i < employees.size(); i++) {
                employees.get(i).printEmployee();
            }
        } else {
            System.out.println("No employees registered yet");
        }
    }


    // change name  //this one or the one below?


    public void updateName() {

        String ID;
        String newName;

        System.out.println("Please enter the ID of the employee whom's name you would like to change: ");
        ID = input.nextLine();

        for (Employee employee : employees) {

            if (employee.getID().equals(ID)) {

                System.out.println("What would you like to update " + employee.getName() + "'s name to?");
                newName = input.nextLine();
                input.nextLine();
                employee.setName(newName);

                System.out.println("Name successfully updated to '" + newName + "'.");
            }
        }
    }

    public void promoteEmployee() {
        Employee promotEmployee = retrieveEmployee();
        String position;
        if (promotEmployee != null) {
            System.out.println("What position would you like to promote " + promotEmployee.getName() + " to?");
            position = input.nextLine();
            if (position.equalsIgnoreCase("employee")) {
                if (promotEmployee instanceof Intern) {
                   employees.remove(promotEmployee);
                   String name = promotEmployee.getName();
                   String ID = promotEmployee.getID();
                }
            }
            if (position.equalsIgnoreCase("manager")) {

            }
            if (position.equalsIgnoreCase("director")) {

            }
        }
    }

    public void updateSalary() {

        String ID;
        double newSalary;

        System.out.println("Please enter the ID of the employee whom's salary you would like to change: ");
        ID = input.nextLine();

        for (Employee employee : employees) {

            if (employee.getID().equals(ID)) {

                System.out.println("What would you like to update " + employee.getName() + "'s salary to?");
                newSalary = input.nextDouble();
                input.nextLine();
                employee.setGrossSalary(newSalary);
                employee.setNetSalary();


                System.out.println(employee.getName() + "'s salary is updated to: " + newSalary);
            }
        }
    }


    public void calcGrossSalaries() {

        if (employees.isEmpty()) {
            System.out.println("There are currently no employees registered.");

        } else {

            double totalGrossSalaries = 0;

            for (int i = 0; i < employees.size(); i++) {
                employees.get(i).getGrossSalary();
                totalGrossSalaries += employees.get(i).getGrossSalary();
            }

            System.out.println("ReusaxCorp's salary expenses are: " + totalGrossSalaries + " SEK.");

        }
    }

    public void calcNetSalaries() {

        if (employees.isEmpty()) {
            System.out.println("There are currently no employees registered.");

        } else {

            double totalNetSalaries = 0;

            for (int i = 0; i < employees.size(); i++) {
                employees.get(i).getNetSalary();
                totalNetSalaries += employees.get(i).getNetSalary();

            }

            System.out.println("ReusaxCorp's salary expenses are: " + totalNetSalaries + " SEK.");

        }
    }


    private int totalNumOfEmployees() {

        if (employees.isEmpty()) {
            System.out.println("There are currently no employees registered.");

            return 0;
        } else {

            int size = 0;

            for (int i = 0; i < employees.size(); i++) {

                size = employees.size();

            }
            //(Employee employee : employees) {

            System.out.println("ReusaxCorp has " + size + " employees registered.");

            return size;

        }
    }

    public void run() {


        int option;

        do {
            ioRef.printMenu();
            System.out.print(" Type the option number: ");

            option = input.nextInt();
            input.nextLine();

            switch (option) {

                case 1:
                    registerEmployee();
                    break;

                case 2:
                    removeEmployee();
                    break;

                case 3:
                    retrieveEmployee();
                    break;

                case 4:
                    updateName();
                    break;

                case 5:
                    updateSalary();
                    break;

                case 6:
                    calcGrossSalaries();
                    break;

                case 7:
                    calcNetSalaries();
                    break;

                case 8:
                    printAllEmployees();
                    break;

                case 9:
                    setDirectorBenefit();
                    break;

                default:
                    System.out.println("Option " + option + " is not valid.");
                    System.out.println();
                    break;
            }
        } while (option != 10);
    }

    public void setDirectorBenefit() {
        System.out.println("What would you like the director's benefit to be?");
        Double benefit = input.nextDouble();
        Director.benefit = benefit;

        for (Employee employee : employees) {
            System.out.println("Salary total: " + employee.getNetSalary());
        }
    }
}