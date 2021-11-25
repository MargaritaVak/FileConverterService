json_to_xml
package Converter;

import org.json.simple.parser.ParseException;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;

public interface FileConverter {
    public void convert(String xmlFileName,String jsonFileName) throws IOException, ParserConfigurationException, SAXException, ParseException, XMLStreamException;
}
=======
package Converter;

import org.json.simple.parser.ParseException;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;

public interface FileConverter {
    public void convert(String xmlFileName,String jsonFileName) throws IOException, ParserConfigurationException, SAXException, ParseException, XMLStreamException;
}

main