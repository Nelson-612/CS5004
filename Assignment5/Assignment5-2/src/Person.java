public abstract class Person {
  private String firstName;
  private String lastName;

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return this.lastName;
  }
  public String getFirstName() {
    return this.firstName;
  }

  public Person(String lastName, String firstName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }
}
