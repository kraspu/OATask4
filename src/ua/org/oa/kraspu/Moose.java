package ua.org.oa.kraspu;


public class Moose {

  private String firstName;
  private String lastName;

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Moose(String firstName, String lastName) {
    this.setFirstName(firstName);
    this.setLastName(lastName);
  }


}
