package fileRead;

import org.jetbrains.annotations.NotNull;
import org.json.simple.parser.ParseException;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;


public interface Read {
    @NotNull Object read(@NotNull String fileName) throws IOException, SAXException, ParserConfigurationException, ParseException;
}
