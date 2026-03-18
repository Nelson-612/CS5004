import java.util.Arrays;
import java.util.Objects;
public class Employee implements Comparable<Employee> {
  private String lastName;
  private int employeeID;
  private double salary;

  public Employee() {
    this.lastName = null;
    this.employeeID = 0;
    this.salary = 0.0;
  }

  public Employee(String lastName, int employeeID, double salary) {
    this.lastName = lastName;
    this.employeeID = employeeID;
    this.salary = salary;
  }

  public Employee(Employee other) {
    if (other == null) {
      throw new IllegalArgumentException("Cannot copy null Employee");
    }
    this.lastName = other.lastName;
    this.employeeID = other.employeeID;
    this.salary = other.salary;
  }

  public String getLastName() {
    return lastName;
  }

  public int getEmployeeID() {
    return employeeID;
  }

  public double getSalary() {
    return salary;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setEmployeeID(int employeeID) {
    this.employeeID = employeeID;
  }

  public void setSalary(double salary) {
    this.salary = salary;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (! (obj instanceof Employee))return false;

    Employee other = (Employee) obj;

    return Object.equals(lastName, other.lastName)&&
        employeeID == other.employeeID&&
        Double.compares(salary, other.salary) == 0;
  }

  @Override
  public String toString() {
    return "Employee{" +
        "lastName='" + lastName + '\'' +
        ", employeeID=" + employeeID +
        ", salary=" + salary +
        '}';
  }

  @Override
  public int compareTo (Employee other) {
    return Integer.compare(this.employeeID, other.employeeID);
  }

  public static void main(String[] args) {
    Employee[] employees = new Employee[5];

    employees[0] = new Employee("A", 100,10000);
    employees[1] = new Employee("B", 101,10001);
    employees[2] = new Employee("C", 102,10002);
    employees[3] = new Employee("D", 103,10003);
    employees[4] = new Employee("E", 104,10004);

    Arrays.sort(employees);

    for (Employee e: employees) {
      System.out.println(e);
    }
  }

}




// "1️⃣ Is the class abstract or concrete?
//
//⸻
//
//2️⃣ Identify:
//	•	Its superclass
//	•	Its subclasses (if any)
//
//⸻
//
//3️⃣ Explain ALL methods:
//
//For each method:
//	•	What is the input?
//	•	What does it do?
//	•	What does it return?
//
//⸻
//
//4️⃣ Explain ALL variables:
//
//For each variable:
//	•	What is its purpose?
//	•	What is its access level?



//public class Question3Test {
//
//    public static void main(String[] args) {
//
//        Device d1 = new Laptop(100, "Dell");
//        Device d2 = new Tablet(200, "Apple");
//        Device d3 = new GamingLaptop(300, "Asus");
//
//        System.out.println(d1.serviceFee());
//        System.out.println(d2.serviceFee());
//        System.out.println(d3.serviceFee());
//
//        System.out.println(d1 instanceof Laptop);
//        System.out.println(d2 instanceof Laptop);
//        System.out.println(d3 instanceof Laptop);
//    }
//}

class RentalSystem {
  private Rental[] rentals;

  public RentalSystem(int size) {
    rentals = new Rental[size];
  }

  public void setRental(Rental r, int index) {
    rentals[index] = r;
  }

  public double totalFees() {
    double total = 0;
    for (Rental r : rentals) {
      total += r.calculateFee();
    }
    return total;
  }
}