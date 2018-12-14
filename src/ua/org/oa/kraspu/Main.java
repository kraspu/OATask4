package ua.org.oa.kraspu;

import java.util.ArrayList;
import java.util.Scanner;

/*    TASK 4:
1. Создать иерархию классов, описывающую заданные объекты

2. Поля каждого из создаваемых классов должны быть инкапсулированы

3. Предусмотреть инициализацию полей на этапе создания объектов класса

4. При необходимости переопределить специфические методы в дочерних классах

5. Все объекты, указанные в задании, должны быть объединены в один массив или ArrayList.

6. На этапе составления программы должны быть использованы соглашения из java code convention.

7. Имя пакета в котором создается класс/классы должно иметь формат ua.org.oa.<Jira Login>.

Создать классы, описывающие студента, преподавателя, декана. Создать 5 объектов различных типов.
Определить методы для вывода информации об объектах:

все студенты, которые учатся в одной группе
преподавателей, имеющих звание доцент
студенты, чем рейтинг в указанном диапазоне
 */

public class Main {

  public static void main(String[] args) {

    ArrayList<Moose> people = new ArrayList<>();

    people.add(new Dean("Oleksiy","Ivanov", true, false));
    people.add(new Lecturer("Dmytro","Tsyplenkov",true,false,true,
                            false,true,false));
    people.add(new Lecturer("Andriy","Kolb",true,false,true,
                            false,true,false));
    people.add(new Lecturer("Fedir","Shkrabets",false,true,true,
                            false,false,true));
    people.add(new Student("Oleksandr","Ahmedov","141m-18-3", 90));
    people.add(new Student("Vadym","Vedmedenko","141m-18-3", 70));
    people.add(new Student("Tetyana","Lyabagova","141-18-3", 95));

    studentInfo(people);
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter group: ");
    String gr = sc.next();
    studentGroupInfo(people, gr);

    System.out.println("Enter min Rate: ");
    int minRate = sc.nextInt();
    System.out.println("Enter max Rate: ");
    int maxRate = sc.nextInt();
    studentRateInfo(people, minRate, maxRate);

    System.out.println("-----------------------------------");

    System.out.println("Associate Professors:");
    lecturerAssPrInfo(people);



  }

  static void studentInfo(ArrayList<Moose> arr) {
    for (int i = 0; i < arr.size(); i++) {
      if ((arr.get(i) instanceof Student)) {
        ((Student) arr.get(i)).print();
      }
    }
  }

  static void studentRateInfo(ArrayList<Moose> arr, int min, int max){
    for (int i = 0; i < arr.size(); i++) {
      if ((arr.get(i) instanceof Student) &&
              ((Student) arr.get(i)).getRate() >= min &&
              ((Student) arr.get(i)).getRate() <= max) {
        ((Student) arr.get(i)).print();
      }
    }
  }

  static void studentGroupInfo(ArrayList<Moose> arr, String str) {
    for (int i = 0; i < arr.size(); i++) {
      if ((arr.get(i) instanceof Student) && (str.equals(((Student) arr.get(i)).getGroup()))) {
        ((Student) arr.get(i)).print();
      }
    }
  }
  static void lecturerAssPrInfo(ArrayList<Moose> arr) {
    for (int i = 0; i < arr.size(); i++) {
      if ((arr.get(i) instanceof Dean) && (((Dean) arr.get(i)).isTitleAssociateProfessor())) {
        ( (Dean)arr.get(i)).print();
      }
    }
  }

}