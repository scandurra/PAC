import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxParser extends DefaultHandler{
  List<Employee> employees;

  private String tmp;
  private Employee currentEmployee;

  public SaxParser() {
    employees = new ArrayList<Employee>();
  }  

  public void parseDocument(String path) {
    SAXParserFactory spf = SAXParserFactory.newInstance();

    // Disabilitiamo la validazione: non abbiamo un DTD
		spf.setValidating(false);

    try {
      SAXParser sp = spf.newSAXParser();

			// Parsing del file al percorso `path` con la classe che gestisce i callback
			// (questa, quindi this)
      sp.parse(path, this);

    } catch(Exception e) {
      e.printStackTrace();
		}
  }

  public void printEmployees() {
    System.out.println("Number of Employees '" + employees.size() + "'.");
    for (Employee i : employees) {
      System.out.println(i.toString());
    }
  }

  // Evento di apertura del tag nel file XML
  public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
    // Reset delle variabili temporanee usate per la lettura
    tmp = "";
    if (qName.equalsIgnoreCase("employee")) {
      currentEmployee = new Employee();
      currentEmployee.setType(attributes.getValue("type"));
    }
  }

  // Evento PCDATA nel file XML
  public void characters(char[] ch, int start, int length) throws SAXException {
    tmp = new String(ch, start, length);
  }

  // Evento chiusura tag nel file XML
  public void endElement(String uri, String localName, String qName) throws SAXException {
    if (qName.equalsIgnoreCase("employee")) {
      employees.add(currentEmployee);
    } else if (qName.equalsIgnoreCase("name")) {
      currentEmployee.setName(tmp);
    } else if (qName.equalsIgnoreCase("id")) {
      currentEmployee.setId(Integer.parseInt(tmp));
    } else if (qName.equalsIgnoreCase("age")) {
      currentEmployee.setAge(Integer.parseInt(tmp));
    }  
  }
}
