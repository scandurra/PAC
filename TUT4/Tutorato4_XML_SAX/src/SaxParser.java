import java.net.ContentHandler;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

// public class SaxParser implements org.xml.sax.ContentHandler, org.xml.sax.ErrorHandler {
public class SaxParser extends DefaultHandler {
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
	
	// Error helper
	// Utile ridefinire gli errori nel caso si utilizzi DefaultHandler
	// Nel caso di implementazione diretta di ErrorHandler, è obbligatorio.

	@Override
	public void warning(SAXParseException exception) throws SAXException {
		System.out.println("SAXParseException warning " + exception.getMessage());
	}

	@Override
	public void error(SAXParseException exception) throws SAXException {
		System.out.println("SAXParseException error " + exception.getMessage());
	}

	@Override
	public void fatalError(SAXParseException exception) throws SAXException {
		System.out.println("SAXParseException fatal error " + exception.getMessage());
	}

	// ContentHandler interface methods implementation
	/*
	@Override
	public void setDocumentLocator(Locator locator) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void startPrefixMapping(String prefix, String uri) throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void endPrefixMapping(String prefix) throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void processingInstruction(String target, String data) throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void skippedEntity(String name) throws SAXException {
		// TODO Auto-generated method stub
		
	}
	*/
}
