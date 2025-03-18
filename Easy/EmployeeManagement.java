package Easy;

import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void displayEmployee() {
        System.out.println("ID: " + id + ", Name: " + name + ", Salary: " + salary);
    }
}

public class EmployeeManagement {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n1. Add Employee\n2. Update Employee\n3. Remove Employee\n4. Search Employee\n5. Display All\n6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            
            if (choice == 1) {
                System.out.print("Enter ID: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter Salary: ");
                double salary = scanner.nextDouble();
                employees.add(new Employee(id, name, salary));
                System.out.println("Employee added successfully!");
                
            } else if (choice == 2) {
                System.out.print("Enter Employee ID to update: ");
                int id = scanner.nextInt();
                for (Employee emp : employees) {
                    if (emp.getId() == id) {
                        scanner.nextLine();
                        System.out.print("Enter New Name: ");
                        emp.setName(scanner.nextLine());
                        System.out.print("Enter New Salary: ");
                        emp.setSalary(scanner.nextDouble());
                        System.out.println("Employee updated successfully!");
                        break;
                    }
                }
                
            } else if (choice == 3) {
                System.out.print("Enter Employee ID to remove: ");
                int id = scanner.nextInt();
                employees.removeIf(emp -> emp.getId() == id);
                System.out.println("Employee removed successfully!");
                
            } else if (choice == 4) {
                System.out.print("Enter Employee ID to search: ");
                int id = scanner.nextInt();
                for (Employee emp : employees) {
                    if (emp.getId() == id) {
                        emp.displayEmployee();
                        break;
                    }
                }
                
            } else if (choice == 5) {
                for (Employee emp : employees) {
                    emp.displayEmployee();
                }
                
            } else if (choice == 6) {
                System.out.println("Exiting...");
                break;
            }
        }
        scanner.close();
    }
}
