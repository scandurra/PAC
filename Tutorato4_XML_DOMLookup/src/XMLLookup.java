import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.w3c.dom.ls.*;
import org.xml.sax.SAXException;

public class XMLLookup {
  public XMLLookup() {
  }

  public Document loadDocument(String path) {
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

    dbf.setValidating(false);
    dbf.setNamespaceAware(false);
    try {
      DocumentBuilder db = dbf.newDocumentBuilder();
      Document d = db.parse(new File(path));
      return d;
    } catch (ParserConfigurationException ex) {
      ex.printStackTrace();
      System.exit(10);
    } catch (SAXException sxe) {
      System.out.println("Il documento contiene errori fatali!");
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
    return null;
  }

  public NodeList getAllDocenti(Document d) {
    // Cerco (per nome) il tag "docenti"
    NodeList droot = d.getElementsByTagName("docenti");

    // Cerco nel sottoalbero del primo (e unico) elementogli elementi il cui tag è "docente"
    NodeList docenti = ((Element)droot.item(0)).getElementsByTagName("docente");
    return docenti;
  }

  public boolean saveNode(Node n, Writer w) {
    DOMImplementationLS ls = (DOMImplementationLS) n.getOwnerDocument().getImplementation();
    LSOutput output = ls.createLSOutput();
    LSSerializer serializer = ls.createLSSerializer();
    try {
      output.setCharacterStream(w);
      output.setEncoding("ISO-8859-1");
      serializer.getDomConfig().setParameter("format-pretty-print", true);
      serializer.getDomConfig().setParameter("xml-declaration", false);
      serializer.write(n, output);
      return true;
    } catch (LSException lse) {
      return false;
    }
  }

  public static void main(String[] args) {
    XMLLookup instance = new XMLLookup();
    Document d = instance.loadDocument("corso.xml");

    if (d != null) {
      NodeList risultati = instance.getAllDocenti(d);

      Writer output = new PrintWriter(System.out);

      for (int i = 0; i < risultati.getLength(); ++i) {
        System.out.println("--- RISULTATO #" + (i + 1));
        instance.saveNode(risultati.item(i), output);
      }
      System.out.println("------------------");
    }
  }
}
