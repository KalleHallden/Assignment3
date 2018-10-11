package assignment3;

import java.util.Scanner;

public class IOclass {
    private Scanner input = new Scanner(System.in);
   // private ReusaxCorp company = new ReusaxCorp();
    private String type;
    private String ID;
    private String name;
    private String degree;
    private String department;
    private double salary;
    private int gpa;

    public String createName(String type) {
        if (!itequals(ID)) {
            System.out.println("Please enter the name of the " + type + " you want to register: ");
            name = input.nextLine();
            return name;
        } else {
            return null;
        }

    }

    public String createID(String type) {
        if (type != null) {
            System.out.println("Please enter the ID of the " + type + " you want to register:");
            ID = input.nextLine();
            return ID;
        } else {
            return null;
        }
    }

    public double createSalary(String type) {
        System.out.println("Please enter the salary of the " + type +" you want to register: ");
        salary = input.nextDouble();
        return salary;
    }

    public String createDegree(String type) {
        input.nextLine();
        System.out.println("Please enter the degree of the " + type + " you want to register:");
        degree = input.nextLine();
        return degree;
    }

    public String createDepartment(String type) {
         System.out.println("Please enter the department of the " + type + " you want to register:");
         department = input.nextLine();
         return department;
    }

    public int createGPA() {
        System.out.println("Please enter the GPA of the intern you want to register:");
        gpa = input.nextInt();
        return gpa;
    }
    static boolean hasBeenDone;
    public String employeeType() {
        if (hasBeenDone) {
         input.nextLine();
        } else {
            hasBeenDone = true;
        }
        System.out.println("Please enter the type of employee you want to register: ");
        type = input.nextLine();

        if (type.equalsIgnoreCase("Manager")) {
            return type;
        }
        if (type.equalsIgnoreCase("Director")) {
            return type;
        }
        if (type.equalsIgnoreCase("Employee")) {
            return type;
        }
        if (type.equalsIgnoreCase("Intern")) {
            return type;
        } else {
            System.out.println("You cannot register an employee of type: " + type);
            hasBeenDone = false;
            return null;
        }
    }

    public static boolean itequals(String id) {
            boolean isRegistered = false;
            if (ReusaxCorp.employees.size() > 0) {
                for (int i = 0; i < ReusaxCorp.employees.size(); i++) {
                    if (ReusaxCorp.employees.get(i).getID().equals(id)) {
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

    public void printMenu() {

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

}