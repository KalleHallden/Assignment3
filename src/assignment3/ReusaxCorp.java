package assignment3;

import java.util.Scanner;
import java.util.ArrayList;


public class ReusaxCorp {

    //private double assets; //for calculating expenses and so on?

    private Scanner input = new Scanner(System.in);

    private ArrayList<Employee> employees;

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

        String type = employeeType();
        Employee employee;

        if (type != null) {
            System.out.println("Please enter the ID of the " + type +" you want to register:");
            String ID = input.nextLine();

            if (!itequals(ID)){
                System.out.println("Please enter the name of the " + type + " you want to register: ");
                String name = input.nextLine();

                System.out.println("Please enter the salary of the " + type +" you want to register: ");
                Double grossSalary = input.nextDouble();

                if (type.equalsIgnoreCase("manager")) {
                    createManager(name, ID, grossSalary);
                } if (type.equalsIgnoreCase("intern")) {
                    createIntern(name, ID, grossSalary);
                } if (type.equalsIgnoreCase("director")) {
                    createDirector(name, ID, grossSalary);
                } if (type.equalsIgnoreCase("employee")) {
                    employee = new Employee(name, ID, grossSalary);
                    employee.setNetSalary();
                    employees.add(employee);
                }
            }
        }
    }

    public void createIntern(String name, String ID, double grossalary) {
        System.out.println("Please enter the GPA of the intern you want to register:");
        int gpa = input.nextInt();

        Intern intern = new Intern(name, ID, grossalary, gpa);
        intern.setNetSalary();
        employees.add(intern);
    }

    public void createManager(String name, String ID, double grossalary) {
        input.nextLine();
        System.out.println("Please enter the degree of the manager you want to register:");
        String degree = input.nextLine();

        Manager manager = new Manager(name, ID, grossalary, degree);
        manager.setBonus();
        manager.setNetSalary();
        employees.add(manager);
    }

    public void createDirector(String name, String ID, double grossalary) {
        input.nextLine();
        System.out.println("Please enter the degree of the director you want to register:");
        String degree = input.nextLine();

        System.out.println("Please enter the department of the director you want to register:");
        String department = input.nextLine();

        System.out.println("Degree: " + degree);

        Director director = new Director(name, ID, grossalary, degree, department);
        director.setBonus();
        director.setNetSalary();
        employees.add(director);

    }

    public boolean itequals(String id) {
        boolean isRegistered = false;
        if (employees.size() > 0) {
            for (int i = 0; i < employees.size(); i++) {
                if (employees.get(i).getID().equals(id)) {
                    isRegistered = true;
                }
            }
        }

        if (!isRegistered) {

        } else if (isRegistered) {
            System.out.println("You cannot register a new employee with the same ID as an existing one, try again.");
        }
        return isRegistered;
    }

    public String employeeType() {

        System.out.println("Please enter the type of employee you want to register: ");
        String type = input.nextLine();

        if (type.equalsIgnoreCase("Manager")) {
            return type;
        }
        if (type.equalsIgnoreCase("Director")) {
            return type;
        }
        if (type.equalsIgnoreCase("Employee")) {
            return type;
        } if (type.equalsIgnoreCase("Intern")) {
            return type;
        } else {
            System.out.println("You cannot register an employee of type: " + type);
            return null;
        }
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



    /*



    public Employee updateName(String ID) {
        //change name

        if (ID != null) {

            for (Employee employee : employees) {

                if (employee.getID().equals(ID)) {

                    Employee.setName(ID, String setName);

                    return employee;
                }
            }
        } return null;
    }


    */

    /*

    public Employee updateSalary(String ID, double newSalary ) {


        // change salary

        if (ID != null) {

            for (Employee employee : employees) {

                if (employee.getID().equals(ID)) {

                    employee.setGrossSalary(newSalary);

                    return employee;
                }

            } return null;
        }
    }

    */

    // change salary  //this one or the one above?

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
            printMenu();
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

    private void printMenu() {

        System.out.println(" === Welcome to ReusaxCorp === ");
        System.out.println(" Choose an option below: ");
        System.out.println(" ");
        System.out.println(" 1. Register an employee. ");
        System.out.println(" 2. Remove employee. ");
        System.out.println(" 3. Retrieve employee. ");
        System.out.println(" 4. Update name. ");
        System.out.println(" 5. Update salary. ");
        System.out.println(" 6. Pay the employees gross salaries. ");
        System.out.println(" 7. Pay the employees net salaries. ");
        System.out.println(" 8. How many employees do we have?  ");
        System.out.println(" 9. Set directors benefit. ");
        System.out.println(" 10. Quit this program. ");
        System.out.println();
    }

    public static void main(String[] args) {
        ReusaxCorp program = new ReusaxCorp();
        program.run();

    }
}