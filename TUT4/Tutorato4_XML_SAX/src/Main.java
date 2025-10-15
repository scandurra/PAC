public class Main {
  public static void main(String[] args) {
    String file = "employees.xml";
    SaxParser spe = new SaxParser();
    spe.parseDocument(file);
    spe.printEmployees();
  }
}
