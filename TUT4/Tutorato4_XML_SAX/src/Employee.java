public class Employee {
  String name;
  int age;
  int id;
  String type;

  public Employee() {}

  public Employee(String name, int id, int age, String type) {
    this.name = name;
    this.age = age;
    this.id = id;
    this.type = type;
  }

  public void setName(String name) {
    this.name = name;
  };
  public void setAge(int age) {
    this.age = age;
  };
  public void setId(int id) {
    this.id = id;
  };
  public void setType(String type) {
    this.type = type;
  };

  public String toString() {
    return ("[Employee " + id + "] " + name + ", " + age + " yo, " + type);
  }
}
