import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class Main {

  public static void lookupDocument(String path) {
    LookupHandler h = new LookupHandler();

    SAXParserFactory spf = SAXParserFactory.newInstance();
    spf.setValidating(true);
    spf.setNamespaceAware(false);

    try {
      SAXParser sp = spf.newSAXParser();
      sp.parse(path, h);

      if (h.hadProblems()) {
        System.out.println("Il documento contiene errori.");
      }
    } catch (ParserConfigurationException ex) {
      ex.printStackTrace();
      System.exit(10);
    } catch (SAXException sxe) {
      System.out.println("Il documento contiene errori fatali!");
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }

  public static void main(String[] args) {
    lookupDocument("corso.xml");
  }
}
