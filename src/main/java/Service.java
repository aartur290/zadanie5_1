import java.util.Collection;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Service {

  public void addStudent(Student student) throws IOException {
    var f = new FileWriter("db.txt", true);
    var b = new BufferedWriter(f);
    b.append(student.ToString());
    b.newLine();
    b.close();
  }

  public Collection<Student> getStudents() throws IOException {
    var ret = new ArrayList<Student>();
    var f = new FileReader("db.txt");
    var reader = new BufferedReader(f);
    String line = "";
    while (true) {
      line = reader.readLine();
      if (line == null)
        break;
      ret.add(Student.Parse(line));
    }
    reader.close();
    return ret;
  }

  public Collection<Student> findStudentByName(String name) throws IOException {
    var list = new ArrayList<Student>();
    var student = getStudents();
    for (Student current : student)
      if (current.GetName().equals(name))
        list.add(current);

    // System.out.println(list);

    return list;
  }

  public void deleteStudent(String name, String lastName) throws IOException {
    boolean flag = true;
    System.out.println("----------");
    System.out.println("Deleting student: " + name + " " + lastName);
    var student = getStudents();

    BufferedWriter bw = new BufferedWriter(new FileWriter("db.txt"));
    for (Student current : student)
      if (!(current.GetName().equals(name) && current.GetLastName().equals(lastName))) {
        bw.write(current.ToString());
        bw.newLine();
      } else
        flag = false;

    if (flag)
      System.out.println("Student not found");
    bw.close();
  }

  public void changeAge(String name, String lastName, int age) throws IOException {
    boolean flag = true;
    var student = getStudents();
    for (Student current : student)
      if (current.GetName().equals(name) && current.GetLastName().equals(lastName))
      {
        current.SetAge(age);
        flag = false;
      }

    if (flag) {
      System.out.println("----------");
      System.out.println("Student not found");
    }
    BufferedWriter bw = new BufferedWriter(new FileWriter("db.txt"));
    for (Student current : student) {
      bw.write(current.ToString());
      bw.newLine();
    }
    bw.close();

  }
}