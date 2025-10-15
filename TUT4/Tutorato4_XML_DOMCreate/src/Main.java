import java.io.FileWriter;
import java.io.IOException;

import org.w3c.dom.Document;

public class Main {

  public static void main(String[] args) {
    String nome = "nome corso";
    String codice = "38090";

    Argomento[] argomenti = {
        new Argomento("Arg1", 3),
        new Argomento("Arg2", 5),
        new Argomento("Arg3", 1),
    };

    XMLCreate instance = new XMLCreate();

    Document d = instance.createDocument();
    instance.createCorso(d, nome, codice, argomenti);

    try {
      instance.saveDocument(d, new FileWriter("Corso_" + args[1] + ".xml"));
      // Su stdout
      // instance.saveDocument(d, new PrintWriter(System.out));
    } catch (IOException ex) {
      ex.printStackTrace();
    }

  }
}
