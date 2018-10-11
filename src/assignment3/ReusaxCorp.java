package assignment3;


import assignment3.Classes.Director;
import assignment3.Classes.Employee;
import assignment3.Classes.Intern;
import assignment3.Classes.Manager;
import assignment3.Input_Output.IOclass;

import java.util.ArrayList;


public class ReusaxCorp {



    public static ArrayList<Employee> employees;
    private IOclass ioRef = new IOclass();



    public ReusaxCorp() {
        employees = new ArrayList<>();


    }


    private void registerEmployee() {
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
        String ID = ioRef.retrieveEmployee();
        if (employees.size() > 0) {
            for (Employee employee : employees) {

                if (employee.getID().equals(ID)) {
                    //employees.get(i).printEmployee();
                    return employee;
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
                System.out.println("======================================");
            }
        } else {
            System.out.println("No employees registered yet");
        }
    }


    public void updateName() {
        String newName;
        Employee nameEmployee = retrieveEmployee();
            if (nameEmployee != null) {
                newName = ioRef.setNewName(nameEmployee.getID());
                nameEmployee.setName(newName);
                System.out.println("Name successfully updated to '" + newName + "'.");
            }
    }

    public void updateSalary() {
        double newSalary;
        Employee salaryEmployee = retrieveEmployee();

            if (salaryEmployee != null) {
                newSalary = ioRef.updateSalary(salaryEmployee.getName());
                salaryEmployee.setGrossSalary(newSalary);
                salaryEmployee.setNetSalary();
                System.out.println(salaryEmployee.getName() + "'s salary is updated to: " + newSalary);
            }
    }


    public void calcGrossSalaries() {

        if (employees.isEmpty()) {
            System.out.println("There are currently no employees registered.");

        } else {

            double totalGrossSalaries = 0;

            for (Employee employee : employees) {
                totalGrossSalaries += employee.getGrossSalary();
            }

            System.out.println("ReusaxCorp's salary expenses are: " + totalGrossSalaries + " SEK.");

        }
    }

    public void calcNetSalaries() {

        if (employees.isEmpty()) {
            System.out.println("There are currently no employees registered.");

        } else {

            double totalNetSalaries = 0;

            for (Employee employee : employees) {
                totalNetSalaries += employee.getNetSalary();
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

            System.out.println("ReusaxCorp has " + size + " employees registered.");

            return size;

        }
    }

    public void run() {


        int option;

        do {
            ioRef.printMenu();
            option = ioRef.getOption();

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

                case 10:
                    promoteToWhat();
                    break;

                default:
                    System.out.println("Option " + option + " is not valid.");
                    System.out.println();
                    break;
            }
        } while (option != 11);
    }

    private void promoteToWhat() {
        String position = ioRef.promoteToWhat();
        if(position.equalsIgnoreCase("employee")) {
            promoteToEmployee();
        }
        if(position.equalsIgnoreCase("manager")) {
            promoteToManager();
        }
        if(position.equalsIgnoreCase("director")) {
            promoteToDirector();
        }
    }

    private void promoteToEmployee() {
        Employee myNewEmployee = retrieveEmployee();

        if (myNewEmployee != null) {
            if (myNewEmployee instanceof Intern) {
                Intern newIntern = (Intern) myNewEmployee;
                Employee newEmployee = new Employee(newIntern.getName(), newIntern.getID(), newIntern.grossSalary);
                employees.remove(newIntern);
                employees.add(newEmployee);
                newEmployee.setNetSalary();
                newEmployee.printEmployee();
            } else {
                System.out.println("Sorry you cannot promote " + myNewEmployee.getID() + " to an employee.");
                System.out.println("You're probably looking to demote, try option 11.");
            }
        }
    }
    private void promoteToManager() {
        Employee myNewEmployee = retrieveEmployee();

        if (myNewEmployee != null) {
            if (myNewEmployee instanceof Intern) {
                Intern newIntern = (Intern) myNewEmployee;
                String degree = ioRef.createDegree("manager");
                Manager newEmployee = new Manager(newIntern.getName(), newIntern.getID(), newIntern.grossSalary, degree);
                employees.remove(newIntern);
                employees.add(newEmployee);
                newEmployee.setNetSalary();
                newEmployee.setBonus();
                newEmployee.printEmployee();
            } if (myNewEmployee instanceof Director) {
                System.out.println("Sorry you cannot promote " + myNewEmployee.getID() + " to an employee.");
                System.out.println("You're probably looking to demote, try option 11.");
            } else if (!(myNewEmployee instanceof Intern)) {
                Employee newIntern = myNewEmployee;
                String degree = ioRef.createDegree("manager");
                Manager newEmployee = new Manager(newIntern.getName(), newIntern.getID(), newIntern.grossSalary, degree);
                employees.remove(newIntern);
                employees.add(newEmployee);
                newEmployee.setNetSalary();
                newEmployee.setBonus();
                newEmployee.printEmployee();
            }
        }
    }
    private void promoteToDirector() {
        Employee myNewEmployee = retrieveEmployee();
        if (myNewEmployee instanceof Intern) {
            Intern newIntern = (Intern) myNewEmployee;
            String degree = ioRef.createDegree("director");
            String department = ioRef.createDepartment("director");
            Director newEmployee = new Director(newIntern.getName(), newIntern.getID(), newIntern.grossSalary, degree, department);
            employees.remove(newIntern);
            employees.add(newEmployee);
            newEmployee.setNetSalary();
            newEmployee.setBonus();
            newEmployee.printEmployee();
        }
        if (myNewEmployee instanceof Manager) {
            Manager newIntern = (Manager) myNewEmployee;
            String department = ioRef.createDepartment("director");
            Director newEmployee = new Director(newIntern.getName(), newIntern.getID(), newIntern.grossSalary, newIntern.getDegree(), department);
            employees.remove(newIntern);
            employees.add(newEmployee);
            newEmployee.setNetSalary();
            newEmployee.setBonus();
            newEmployee.printEmployee();
        }
        if (!(myNewEmployee instanceof Intern) && !(myNewEmployee instanceof Manager)) {
            Employee newIntern = myNewEmployee;
            String degree = ioRef.createDegree("director");
            String department = ioRef.createDepartment("director");
            Director newEmployee = new Director(newIntern.getName(), newIntern.getID(), newIntern.grossSalary, degree, department);
            employees.remove(newIntern);
            employees.add(newEmployee);
            newEmployee.setNetSalary();
            newEmployee.setBonus();
            newEmployee.printEmployee();
        }
        else if (myNewEmployee instanceof  Director) {
            System.out.println("Sorry you cannot promote " + myNewEmployee.getID() + " to an employee.");
            System.out.println("You're probably looking to demote, try option 11.");
        }
    }



    public void setDirectorBenefit() {
         ioRef.setDirectorBenefit();
    }
}