 json_to_xml
package fileWrite;

import org.jetbrains.annotations.NotNull;

import javax.xml.stream.XMLStreamException;
import javax.xml.transform.TransformerConfigurationException;
import java.io.IOException;


public interface Write {
    void write(@NotNull Object object, @NotNull String fileName) throws IOException, XMLStreamException, TransformerConfigurationException;
}
=======
package fileWrite;

import org.jetbrains.annotations.NotNull;

import javax.xml.stream.XMLStreamException;
import javax.xml.transform.TransformerConfigurationException;
import java.io.IOException;


public interface Write {
    void write(@NotNull Object object, @NotNull String fileName) throws IOException, XMLStreamException, TransformerConfigurationException;
}
main
