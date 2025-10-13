import java.util.Scanner;

class Employee {
    String name;
    String department;
    double salary;

    Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    void display() {
        System.out.println("👤 Employee Name: " + name);
        System.out.println("🏢 Department: " + department);
        System.out.println("💰 Salary: " + salary);
        System.out.println("-----------------------------");
    }
}

public class EmployeeSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Department: ");
        String dept = sc.nextLine();

        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();

        Employee emp = new Employee(name, dept, salary);

        System.out.println("\n Employee Details (Scanner Input):");
        emp.display();

        if (args.length > 0) {
            try {
                double increment = Double.parseDouble(args[0]);
                emp.salary += increment;
                System.out.println("Salary updated by command-line argument: +" + increment);
                emp.display();
            } catch (NumberFormatException e) {
                System.out.println(" Invalid increment amount. Please pass a valid number.");
            }
        } else {
            System.out.println(" No command-line arguments provided for salary update.");
        }

        sc.close();
    } 
}
