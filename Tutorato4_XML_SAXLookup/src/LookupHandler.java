import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class LookupHandler extends DefaultHandler {
  private int nErrors, nWarnings, nFatals;
  private boolean inDocenti, printChars;

  public LookupHandler() {
    reset();
  }

  // Gestione degli errori

  public void reset() {
    nErrors = 0;
    nWarnings = 0;
    nFatals = 0;
    inDocenti = false;
    printChars = false;
  }

  public void warning(SAXParseException e) throws SAXException {
    nWarnings++;
    printException("WARNING", e);
  }

  public void fatalError(SAXParseException e) throws SAXException {
    nFatals++;
    printException("FATAL ERROR", e);
    throw e;
  }

  public void error(SAXParseException e) throws SAXException {
    nErrors++;
    printException("ERROR", e);
  }

  private void printException(String type, SAXParseException e) throws SAXException {
    System.out.println(type + " (" + e.getSystemId() + ":" + e.getLineNumber() + "," + e.getColumnNumber() + ") "
        + e.getMessage());
  }

  public boolean hadProblems() {
    return (nFatals + nErrors) > 0;
  }

  // Callback per SAX

  public void startElement(String uri, String localName, String qName, Attributes attrs) throws SAXException {
    if (inDocenti) {
      if (qName.equals("docente")) {
        System.out.println();
        System.out.print("Docente " + attrs.getValue("rif") + ": ");
      } else if (qName.equals("nome")) {
        System.out.print(" Nome: ");
        printChars = true;
      } else if (qName.equals("cognome")) {
        System.out.print(" Cognome: ");
        printChars = true;
      }
    } else if (qName.equals("docenti"))
      inDocenti = true;
  }

  public void endElement(String uri, String localName, String qName) throws SAXException {
    if (qName.equals("docenti"))
      inDocenti = false;
    else if (qName.equals("nome") || qName.equals("cognome"))
      printChars = false;
  }

  public void characters(char[] ch, int start, int length) throws SAXException {
    if (printChars)
      System.out.print(String.valueOf(ch, start, length));
  }
}
