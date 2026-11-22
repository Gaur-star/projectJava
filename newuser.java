
import java.util.*;
import java.io.*;

// Employee Class
class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    int id;
    String name;
    String department;
    double salary;
    String email;

    Employee(int id, String name, String department,
             double salary, String email) {

        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.email = email;
    }

    void display() {
        System.out.println("--------------------------------");
        System.out.println("Employee ID : " + id);
        System.out.println("Name        : " + name);
        System.out.println("Department  : " + department);
        System.out.println("Salary      : " + salary);
        System.out.println("Email       : " + email);
        System.out.println("--------------------------------");
    }
}

// Main Employee Management System
public class EmployeeManagementSystem {

    static ArrayList<Employee> employees = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);

    static final String FILE_NAME = "employees.dat";

    // Load employees from file
    static void loadEmployees() {

        try (ObjectInputStream in =
             new ObjectInputStream(new FileInputStream(FILE_NAME))) {

            employees = (ArrayList<Employee>) in.readObject();

        } catch (FileNotFoundException e) {
            System.out.println("Starting with an empty employee database.");

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading employee data: " + e.getMessage());
        }
    }

    // Save employees to file
    static void saveEmployees() {

        try (ObjectOutputStream out =
             new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {

            out.writeObject(employees);

        } catch (IOException e) {
            System.out.println("Error saving employee data: " + e.getMessage());
        }
    }

    // Check employee ID
    static Employee findEmployee(int id) {

        for (Employee emp : employees) {
            if (emp.id == id) {
                return emp;
            }
        }

        return null;
    }

    // Add employee
    static void addEmployee() {

        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (findEmployee(id) != null) {
            System.out.println("Employee ID already exists!");
            return;
        }

        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Department: ");
        String department = sc.nextLine();

        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        Employee emp = new Employee(
            id, name, department, salary, email
        );

        employees.add(emp);
        saveEmployees();

        System.out.println("Employee added successfully!");
    }

    // Display all employees
    static void displayEmployees() {

        if (employees.isEmpty()) {
            System.out.println("No employees found!");
            return;
        }

        System.out.println("\n===== EMPLOYEE DETAILS =====");

        for (Employee emp : employees) {
            emp.display();
        }
    }

    // Search employee
    static void searchEmployee() {

        System.out.print("Enter Employee ID to search: ");
        int id = sc.nextInt();

        Employee emp = findEmployee(id);

        if (emp != null) {
            System.out.println("\nEmployee Found!");
            emp.display();
        } else {
            System.out.println("Employee not found!");
        }
    }

    // Update employee
    static void updateEmployee() {

        System.out.print("Enter Employee ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        Employee emp = findEmployee(id);

        if (emp == null) {
            System.out.println("Employee not found!");
            return;
        }

        System.out.print("Enter New Name: ");
        emp.name = sc.nextLine();

        System.out.print("Enter New Department: ");
        emp.department = sc.nextLine();

        System.out.print("Enter New Salary: ");
        emp.salary = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter New Email: ");
        emp.email = sc.nextLine();

        saveEmployees();

        System.out.println("Employee updated successfully!");
    }

    // Delete employee
    static void deleteEmployee() {

        System.out.print("Enter Employee ID to delete: ");
        int id = sc.nextInt();

        Employee emp = findEmployee(id);

        if (emp != null) {
            employees.remove(emp);
            saveEmployees();

            System.out.println("Employee deleted successfully!");

        } else {
            System.out.println("Employee not found!");
        }
    }

    // Main method
    public static void main(String[] args) {

        loadEmployees();

        int choice;

        do {

            System.out.println("\n================================");
            System.out.println("   EMPLOYEE MANAGEMENT SYSTEM");
            System.out.println("================================");

            System.out.println("1. Add Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");

            System.out.println("================================");
            System.out.print("Enter Your Choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addEmployee();
                    break;

                case 2:
                    displayEmployees();
                    break;

                case 3:
                    searchEmployee();
                    break;

                case 4:
                    updateEmployee();
                    break;

                case 5:
                    deleteEmployee();
                    break;

                case 6:
                    saveEmployees();
                    System.out.println("Thank you for using the system!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 6);

        sc.close();
    }
}
