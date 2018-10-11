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
    static boolean hasBeenDone;
    private double salary;
    private int gpa;

    public String createName(String type) {
        hasbeenDonNow();
        if (!itequals(ID)) {
            System.out.println("Please enter the name of the " + type + " you want to register: ");
            name = input.nextLine();
            return name;
        } else {
            return null;
        }

    }

    public String createID(String type) {
        hasbeenDonNow();
        if (type != null) {
            System.out.println("Please enter the ID of the " + type + " you want to register:");
            ID = input.nextLine();
            return ID;
        } else {
            return null;
        }
    }

    public double createSalary(String type) {
        hasbeenDonNow();
        System.out.println("Please enter the salary of the " + type +" you want to register: ");
        salary = input.nextDouble();
        return salary;
    }

    public String createDegree(String type) {
        hasbeenDonNow();
        System.out.println("Please enter the degree of the " + type + " you want to register:");
        degree = input.nextLine();
        return degree;
    }

    public void hasbeenDonNow() {
        if (hasBeenDone) {
            input.nextLine();
        }
    }

    public String createDepartment(String type) {
        hasbeenDonNow();
         System.out.println("Please enter the department of the " + type + " you want to register:");
         department = input.nextLine();
         return department;
    }

    public int createGPA() {
        hasbeenDonNow();
        System.out.println("Please enter the GPA of the intern you want to register:");
        gpa = input.nextInt();
        return gpa;
    }
    
    public String employeeType() {
        if (hasBeenDone) {
         input.nextLine();
        } else {
            hasBeenDone = true;
        }
        System.out.println("Please enter the type of employee you want to register: ");
        type = input.nextLine();

        if (type.equalsIgnoreCase("Manager")) {
            hasBeenDone = false;
            return type;
        }
        if (type.equalsIgnoreCase("Director")) {
            hasBeenDone = false;
            return type;
        }
        if (type.equalsIgnoreCase("Employee")) {
            hasBeenDone = false; 
            return type;
        }
        if (type.equalsIgnoreCase("Intern")) {
            hasBeenDone = false;
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


        public double updateSalary(String name) {
              System.out.println("What would you like to update " + name + "'s salary to?");
              double newSalary = input.nextDouble();
              input.nextLine();
              return newSalary;
        }
         public String setNewName(String ID) {
                 System.out.println("So you messed up.. Please enter the new name for " + ID + ": ");
             System.out.println("And please make sure it's correct this time..");
                 name = input.nextLine();
                 return name;
         }

         public String retrieveEmployee() {
             System.out.println("Please enter the ID of the employee you want to use: ");
             String ID = input.nextLine();
             return ID;
         }

         public int getOption() {
           System.out.print(" Type the option number: ");
           int option = input.nextInt();
           input.nextLine();
           return option;
         }
          public String promoteToWhat() {
              System.out.println("Please enter the position you would like to promote someone to: ");
              String position = input.nextLine();
              return position;
          }
           public void setDirectorBenefit() {
                System.out.println("What would you like the director's benefit to be?");
                Double benefit = input.nextDouble();
                Director.benefit = benefit;
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
            System.out.println(" 10. Promote employee. ");
            System.out.println(" 11. Quit this program. ");
            System.out.println();
        }

}