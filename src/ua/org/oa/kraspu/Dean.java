package ua.org.oa.kraspu;

import java.util.Scanner;

public class Dean extends Moose{

  private boolean phD;
  private boolean positionDean;
  private boolean titleAssociateProfessor;
  private boolean titleProfessor;

  public Dean(String firstName, String lastName, boolean titleAssociateProfessor, boolean titleProfessor) {

    super(firstName, lastName);
    setPhD(true);
    char ans;
    Scanner sc = new Scanner(System.in);

    if (titleAssociateProfessor == titleProfessor) {
      do {
        System.out.println("What's the title of " + this.getFirstName() + " " + this.getLastName() + "?");
        System.out.println("1. Associate Professor; 2. Professor");
        System.out.println("Enter the number: ");
        ans = sc.next().charAt(0);
      } while (ans != '1' || ans != '2');

      switch (ans) {
        case '1': this.setTitleAssociateProfessor(true);
                  this.setTitleProfessor(false);
                  break;
        case '2': this.setTitleAssociateProfessor(false);
                  this.setTitleProfessor(true);
                  break;
        default:  System.out.println("Something went wrong!");
                  break;
      }
    } else {
      this.setTitleAssociateProfessor(titleAssociateProfessor);
      this.setTitleProfessor(titleProfessor);
    }

  }

  public boolean isPhD() {
    return phD;
  }

  public void setPhD(boolean phD) {
    this.phD = phD;
  }

  public boolean isTitleAssociateProfessor() {
    return titleAssociateProfessor;
  }

  public void setTitleAssociateProfessor(boolean titleAssociateProfessor) {
    this.titleAssociateProfessor = titleAssociateProfessor;
  }

  public boolean isTitleProfessor() {
    return titleProfessor;
  }

  public void setTitleProfessor(boolean titleProfessor) {
    this.titleProfessor = titleProfessor;
  }

  public boolean isPositionDean() {
    return true;
  }

  public void setPositionDean(boolean positionDean) {
    this.positionDean = positionDean;
  }

  public void print() {
    System.out.print(getFirstName() + " " + getLastName() + "\n\t Position: Dean ");
    System.out.print("\t Title:");
    if (isTitleProfessor()) System.out.print(" Professor");
    else System.out.print(" Associate Professor");
    if (isPhD()) System.out.print(", PhD");
    System.out.println();
  }
}
