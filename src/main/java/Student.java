public class Student {

  private String Name;
  private String LastName;
  private int Age;
  private String bornDate;

  public Student(String name, String lastName, int age, String born) {
    Name = name;
    LastName = lastName;
    Age = age;
    bornDate = born;
  }

  public String GetName() {
    return Name;
  }

  public int GetAge() {
    return Age;
  }

  public String ToString() {
    return Name + " " + LastName + " " + Integer.toString(Age) + " " + bornDate;
  }

  public static Student Parse(String str) {
    String[] data = str.split(" ");
    if (data.length != 4)
      return new Student("Parse", "Error", -1, "99.99.9999");
    return new Student(data[0], data[1], Integer.parseInt(data[2]), data[3]);
  }
}