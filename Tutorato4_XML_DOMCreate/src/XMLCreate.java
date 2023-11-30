import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.w3c.dom.ls.*;

/*
Struttura desiderata
<corso codice="codice">
	<nome>Nome del corso</nome>
	<descrizione>
		<obiettivi></obiettivi>
		<esame></esame>
	</descrizione>
	<syllabus>
		<argomento crediti="1">Nome</argomento>
		<argomento crediti="1">Nome</argomento>
	</syllabus>
	<docenti>
		<docente rif="IDDocente">
			<nome></nome>
			<cognome></cognome>
		</docente>
	</docenti>
	<testi>
		<testo rif="IDtesto">
			<autore></autore>
			<titolo></titolo>
			<editore></editore>
		</testo>
	</testi>
</corso>
*/

public class XMLCreate {
	/*
	 * Crea un elemento "corso" con le caratteristiche date come parametri
	 * L'implementazione di questo metodo si basa sulle implementazioni di una serie
	 * di altri metodi a cui viene delegata la costruzione dei vari elementi del
	 * documento (descrizione, syllabus, docenti, testi...)
	 */
	public Document createCorso(Document d, String nome, String codice, Argomento[] argomenti) {
		Element radice = d.createElement("corso"); // Elemento radice
		radice.setAttribute("codice", codice);

		Element _nome = d.createElement("nome"); // Nome del corso
		_nome.setTextContent(nome);
		radice.appendChild(_nome);

		radice.appendChild(createDescrizione(d));
		radice.appendChild(createSyllabus(d, argomenti));
		radice.appendChild(createDocenti(d));
		radice.appendChild(createTesti(d));

		d.appendChild(radice); // Inserimento della radice

		return d;
	}

	public Element createDescrizione(Document d) {
		Element descrizione = d.createElement("descrizione");

		Element obiettivi = d.createElement("obiettivi");
		obiettivi.appendChild(d.createComment("Obiettivi formativi del corso"));

		Element esame = d.createElement("esame");
		esame.appendChild(d.createComment("Modalità di esame"));

		descrizione.appendChild(obiettivi);
		descrizione.appendChild(esame);

		return descrizione;
	}

	public Element createSyllabus(Document d, Argomento[] argomenti) {
		Element syllabus = d.createElement("syllabus");

		for (Argomento arg : argomenti) {
			Element e = d.createElement("argomento");
			e.setAttribute("crediti", Integer.toString(arg.crediti));
			e.setTextContent(arg.nome);
			syllabus.appendChild(e);
		}

		return syllabus;

	}

	public Element createDocenti(Document d) {
		Element docenti = d.createElement("docenti");

		Element docente = d.createElement("docente");
		docente.setAttribute("rif", "IDdocente");

		Element nome = d.createElement("nome");
		nome.appendChild(d.createComment("Nome del docente"));
		docente.appendChild(nome);

		Element cognome = d.createElement("cognome");
		cognome.appendChild(d.createComment("Cognome del docente"));
		docente.appendChild(cognome);

		docenti.appendChild(docente);
		return docenti;
	}

	public Element createTesti(Document d) {
		Element testi = d.createElement("testi");

		Element testo = d.createElement("testo");

		Element autore = d.createElement("autore");
		autore.appendChild(d.createComment("Autore del testo"));
		testo.appendChild(autore);

		Element titolo = d.createElement("titolo");
		titolo.appendChild(d.createComment("Titolo del testo"));
		testo.appendChild(titolo);

		Element editore = d.createElement("editore");
		editore.appendChild(d.createComment("Editore del testo"));
		testo.appendChild(editore);

		testi.appendChild(testo);
		return testi;
	}

	// Versione senza DTD
	public Document createDocument() {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setValidating(false);
		dbf.setNamespaceAware(false);
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document d = db.newDocument();
			return d;
		} catch (ParserConfigurationException ex) {
			ex.printStackTrace();
			System.exit(10);
		}
		return null;
	}

	// Versione con DTD
	public Document createDocumentDTD(String radice, String pubid, String sysid) {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setValidating(false); // DTD lo aggiungiamo dopo
		dbf.setNamespaceAware(false);
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();

			DOMImplementation dbi = db.getDOMImplementation();
			DocumentType doctype = dbi.createDocumentType(radice, pubid, sysid);

			Document d = dbi.createDocument("", radice, doctype);
			return d;
		} catch (ParserConfigurationException ex) {
			ex.printStackTrace();
			System.exit(10);
		}
		return null;
	}

	public boolean saveDocument(Document d, Writer w) {
		DOMImplementationLS ls = (DOMImplementationLS) d.getImplementation();
		LSOutput output = ls.createLSOutput();

		LSSerializer serializer = ls.createLSSerializer();
		try {
			output.setCharacterStream(w);
			output.setEncoding("ISO-8859-1");
			serializer.getDomConfig().setParameter("format-pretty-print", true);
			serializer.write(d, output);

			return true;
		} catch (LSException e) {
			return false;
		}
	}
}
