import Converter.JsonToXml;
import Converter.XmlToJson;
import org.json.simple.parser.ParseException;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.IOException;




public class Main {
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException, XMLStreamException, ParseException {
        if (new File("file/output").mkdirs()) {
            System.out.println("Директория для сохранения выходных файлов успешно создана\n");
        }
        if (args.length != 2)
            System.out.println("Должно быть введено два файла");
        else {
            if (args[0].endsWith(".xml") && args[1].endsWith(".json")) {
                XmlToJson converter = new XmlToJson();
                converter.convert(args[0], args[1]);
            }
            else if (args[0].endsWith(".json") && args[1].endsWith(".xml")) {
                JsonToXml converter = new JsonToXml();
                converter.convert(args[0], args[1]);
            }
            else
                System.out.println("Расширение файла не соответствует требуемому");
        }
    }
}
