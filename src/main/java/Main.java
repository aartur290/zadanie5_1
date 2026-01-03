import java.io.IOException;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    try {
      Service s = new Service();
      Scanner scanner = new Scanner(System.in);
      int choose = 0;

      while (true) {
        System.out.println("1. Add student");
        System.out.println("2. Show students");
        System.out.println("3. Find student by name");
        System.out.println("0. Exit");
        System.out.println("----------");
        System.out.print("Choose: ");

        try {
          choose = scanner.nextInt();
        } catch (Exception e) {
          choose = 2077;
        }

        switch (choose) {
          case 1:
            String name = "", lastName = "", bornDate = "";
            int age = 0;
            System.out.print("Enter name: ");
            name = scanner.next();
            System.out.print("Enter last name: ");
            lastName = scanner.next();
            System.out.print("Enter age: ");
            age = scanner.nextInt();
            System.out.print("Enter born date (dd.mm.yyyy): ");
            bornDate = scanner.next();
            s.addStudent(new Student(name, lastName, age, bornDate));
            System.out.println("----------");
            break;
          case 2:
            System.out.println("----------");
            System.out.println("Students:");
            System.out.println("----------");
            var students = s.getStudents();
            for (Student current : students)
              System.out.println(current.ToString());
            System.out.println("----------");
            break;
          case 3:
            System.out.println("----------");
            System.out.print("Enter name: ");
            name = scanner.next();
            System.out.println("----------");
            var found = s.findStudentByName(name);
            if (found.isEmpty())
              System.out.println("Not found");
            else
              for (Student current : found)
                System.out.println(current.ToString());
            System.out.println("----------");
            break;
          case 0:
            System.exit(0);
          default:
            System.out.println("----------");
            System.out.println("Wrong number");
            System.out.println("----------");
        }
      }

    } catch (IOException e) {

    }
  }
}