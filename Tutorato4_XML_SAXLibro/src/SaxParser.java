import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

// La classe che fa il parsing estende anche il DefaultHandler
public class SaxParser extends DefaultHandler {}
