import java.util.Arrays;

public class Student implements Comparable<Student>{
  private String lastName;
  private int id;

  public Student (String lastName, int id) {
    this.lastName = lastName;
    this.id = id;
  }

  public int compareTo(Student other) {
    return this.lastName.compareTo(other.lastName);
  }

  public String getLastName() {return lastName;}
  public int getId() {return id;}

  public void setLastName(String lastName) {this.lastName = lastName;}
  public void setId(int id) {this.id = id;}

  @Override
  public String toString() {
    return "Last Name: " + lastName + "id: " + id;
  }

  public static void main (String[] args) {
    Student[] students = new Student[5];
    students[0] = new Student("A", 100);
    students[1] = new Student("B", 200);
    students[2] = new Student("C", 300);
    students[3] = new Student("D", 400);
    students[4] = new Student("E", 500);
    Arrays.sort(students);

    for (int i = 0; i < students.length; i++) {
      System.out.println(students[i]);
    }
  }


}
