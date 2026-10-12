package Self_learning;

import java.util.*;

class Employee {
    int id;
    String name;
    double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    void display() {
        System.out.println(
                "ID: " + id +
                        ", Name: " + name +
                        ", Salary: " + salary
        );
    }
}

public class Practice1 {
    public static void main(String[] args) {

        ArrayList<Employee> employees = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        employees.add(new Employee(103, "Aman", 30000));
        employees.add(new Employee(101, "Riya", 40000));
        employees.add(new Employee(104, "Rahul", 25000));
        employees.add(new Employee(102, "Priya", 35000));

        System.out.println("Original Employee List:");
        for (Employee e : employees) {
            e.display();
        }

        System.out.println("\nSearch Employee with ID 102:");

        for (Employee e : employees) {
            if (e.id == 102) {
                e.display();
                break;
            }
        }

        for (Employee e : employees) {
            if (e.id == 102) {
                e.salary = 45000;
                break;
            }
        }

        System.out.println("\nAfter Updating Salary:");
        for (Employee e : employees) {
            e.display();
        }

        Iterator<Employee> it = employees.iterator();

        while (it.hasNext()) {
            Employee e = it.next();

            if (e.id == 104) {
                it.remove();
            }
        }

        System.out.println("\nAfter Deleting Employee ID 104:");
        for (Employee e : employees) {
            e.display();
        }

        System.out.println("\nUsing Iterator :");

        Iterator<Employee> iterator = employees.iterator();

        while (iterator.hasNext()) {
            Employee e = iterator.next();
            e.display();
        }

        System.out.println("\nUsing ListIterator :");

        ListIterator<Employee> listIterator =
                employees.listIterator();

        while (listIterator.hasNext()) {
            Employee e = listIterator.next();
            e.display();
        }

        System.out.println("\nUsing ListIterator (Backward):");

        while (listIterator.hasPrevious()) {
            Employee e = listIterator.previous();
            e.display();
        }

        Collections.sort(employees,
                Comparator.comparingInt(e -> e.id));

        System.out.println("\nIncreasing Order of ID:");

        for (Employee e : employees) {
            e.display();
        }

        Collections.sort(employees,
                Comparator.comparingInt((Employee e) -> e.id)
                        .reversed());

        System.out.println("\nDecreasing Order of ID:");

        for (Employee e : employees) {
            e.display();
        }

        sc.close();
    }
}







//package Self_learning;
//
//import java.util.*;
//
//class Employee {
//    private int id;
//    private String name;
//    private double salary;
//
//    Employee(int id, String name, double salary) {
//        this.id = id;
//        this.name = name;
//        this.salary = salary;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public double getSalary() {
//        return salary;
//    }
//
//    public void setSalary(double salary) {
//        this.salary = salary;
//    }
//
//    public void display() {
//        System.out.println(
//                "ID: " + id +
//                        ", Name: " + name +
//                        ", Salary: " + salary
//        );
//    }
//}
//
//public class Practice1 {
//    public static void main(String[] args) {
//
//        ArrayList<Employee> employees = new ArrayList<>();
//
//        employees.add(new Employee(103, "Aman", 30000));
//        employees.add(new Employee(101, "Riya", 40000));
//        employees.add(new Employee(104, "Rahul", 25000));
//        employees.add(new Employee(102, "Priya", 35000));
//
//        System.out.println("All Employees:");
//        for (Employee e : employees) {
//            e.display();
//        }
//
//        System.out.println("\nSearching Employee with ID 102:");
//
//        for (Employee e : employees) {
//            if (e.getId() == 102) {
//                e.display();
//                break;
//            }
//        }
//
//        System.out.println("\nUpdating Salary:");
//
//        for (Employee e : employees) {
//            if (e.getId() == 102) {
//                e.setSalary(45000);
//                System.out.println("Salary updated successfully.");
//                break;
//            }
//        }
//
//        System.out.println("\nDeleting Employee with ID 104:");
//
//        Iterator<Employee> iterator = employees.iterator();
//
//        while (iterator.hasNext()) {
//            Employee e = iterator.next();
//
//            if (e.getId() == 104) {
//                iterator.remove();
//                System.out.println("Employee deleted successfully.");
//                break;
//            }
//        }
//
//        System.out.println("\nTraversal using Iterator:");
//
//        Iterator<Employee> itr = employees.iterator();
//
//        while (itr.hasNext()) {
//            Employee e = itr.next();
//            e.display();
//        }
//
//        System.out.println("\nForward Traversal using ListIterator:");
//
//        ListIterator<Employee> listItr = employees.listIterator();
//
//        while (listItr.hasNext()) {
//            Employee e = listItr.next();
//            e.display();
//        }
//
//        System.out.println("\nBackward Traversal using ListIterator:");
//
//        while (listItr.hasPrevious()) {
//            Employee e = listItr.previous();
//            e.display();
//        }
//
//        Collections.sort(employees, Comparator.comparingInt(Employee::getId));
//
//        System.out.println("\nEmployees Sorted by ID (Ascending):");
//
//        for (Employee e : employees) {
//            e.display();
//        }
//
//        Collections.sort(
//                employees,
//                Comparator.comparingInt(Employee::getId).reversed()
//        );
//
//        System.out.println("\nEmployees Sorted by ID (Descending):");
//
//        for (Employee e : employees) {
//            e.display();
//        }
//    }
//}
