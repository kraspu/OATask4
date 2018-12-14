package ua.org.oa.kraspu;

import java.util.Scanner;

public class Lecturer extends Dean{

  private boolean phD;
  private boolean positionAssociateProfessor;
  private boolean positionAssistant;
  private boolean positionProfessor;
  private boolean positionDean;
  private boolean titleAssociateProfessor;
  private boolean titleProfessor;


  public boolean isPositionAssociateProfessor() {
    return positionAssociateProfessor;
  }

  public void setPositionAssociateProfessor(boolean positionAssociateProfessor) {
    this.positionAssociateProfessor = positionAssociateProfessor;
  }

  public boolean isPositionAssistant() {
    return positionAssistant;
  }

  public void setPositionAssistant(boolean positionAssistant) {
    this.positionAssistant = positionAssistant;
  }

  public boolean isPositionProfessor() {
    return positionProfessor;
  }

  public void setPositionProfessor(boolean positionProfessor) {
    this.positionProfessor = positionProfessor;
  }

  @Override
  public boolean isPositionDean() {
    return false;
  }


  public Lecturer(String firstName, String lastName, boolean titleAssociateProfessor, boolean titleProfessor, boolean phD,
                  boolean positionAssistant, boolean positionAssociateProfessor, boolean positionProfessor) {

    super( firstName,  lastName,  titleAssociateProfessor,  titleProfessor);
    super.setPhD(phD);
    char ans;
    Scanner sc = new Scanner(System.in);

    if (
            (positionAssistant && positionAssociateProfessor)  ||
            (positionAssistant && positionProfessor)  ||
            (positionAssociateProfessor && positionProfessor)  ) {

      do {
        System.out.println("What's the position of " + this.getFirstName() + " " + this.getLastName() + "?");
        System.out.println("1. Assistant; 2. Associate Professor; 3. Professor");
        System.out.println("Enter the number: ");
        ans = sc.next().charAt(0);
      } while (ans != '1' || ans != '2' || ans != '3');

      switch (ans) {
        case '1': this.setPositionAssistant(true);
                  this.setPositionAssociateProfessor(false);
                  this.setPositionProfessor(false);
                  break;
        case '2': this.setPositionAssistant(false);
                  this.setPositionAssociateProfessor(true);
                  this.setPositionProfessor(false);
                  break;
        case '3': this.setPositionAssistant(false);
                  this.setPositionAssociateProfessor(false);
                  this.setPositionProfessor(true);
                  break;
        default:  System.out.println("Something went wrong!");
                  break;
      }
    } else {
      this.setPositionAssistant(positionAssistant);
      this.setPositionAssociateProfessor(positionAssociateProfessor);
      this.setPositionProfessor(positionProfessor);
    }


  }
  @Override
  public void print() {
    System.out.print(getFirstName() + " " + getLastName() + "\n\t Position:");
    if (isPositionAssistant()) System.out.print(" assistant ");
    else if (isPositionAssociateProfessor()) System.out.print(" Associate Professor ");
    else System.out.print(" Professor ");
    System.out.print("\t Title:");
    if (isTitleProfessor()) System.out.print(" Professor");
    else System.out.print(" Associate Professor");
    if (isPhD()) System.out.print(", PhD");
    System.out.println();
  }

}
