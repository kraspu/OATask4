package ua.org.oa.kraspu;

import java.util.Scanner;

public class Student extends Moose {

  private String group;
  private int rate;  // Rate between 0 - 100

  public String getGroup() {
    return group;
  }

  public void setGroup(String group) {
    this.group = group;
  }

  public int getRate() {
    return rate;
  }

  public void setRate(int rate) {
    this.rate = rate;
  }

  public Student(String firstName, String lastName, String group, int rate) {
    super(firstName, lastName);
    this.setGroup(group);
    Scanner sc = new Scanner(System.in);
    do {
      if (rate > 100 || rate < 0) {
        System.out.println("Enter rate (0 - 100): ");
        setRate(sc.nextInt());
      } else {
        this.setRate(rate);
      }
    }while (rate > 100 || rate < 0);
  }

  public void print() {
    System.out.println(getFirstName() + " " + getLastName() + " " + getGroup() + " " + getRate());
  }
}
