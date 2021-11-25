json_to_xml
import Converter.JsonToXml;
import org.jetbrains.annotations.NotNull;
import org.json.simple.parser.ParseException;

import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.IOException;



public class JsonToXmlConverter {
    public static void main(String @NotNull [] args) throws IOException, XMLStreamException, ParseException {
        if (args.length != 2) {
           throw new IllegalArgumentException("Некорректное количество аргументов");
        }

        if (new File("file/output").mkdirs()) {
            System.out.println("Директория для сохранения выходных файлов успешно создана\n");
        }

        JsonToXml converter = new JsonToXml();
        converter.convert(args[0], args[1]);
        System.out.println("Преобразование прошло успешно, результат сохранен в файл " + args[1]);
    }
}
=======
import Converter.JsonToXml;
import org.jetbrains.annotations.NotNull;
import org.json.simple.parser.ParseException;

import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.IOException;



public class JsonToXmlConverter {
    public static void main(String @NotNull [] args) throws IOException, XMLStreamException, ParseException {
        //if (args.length != 2) {
        //    throw new IllegalArgumentException("Некорректное количество аргументов");
        //}

        if (new File("file/output").mkdirs()) {
            System.out.println("Директория для сохранения выходных файлов успешно создана\n");
        }

        JsonToXml converter = new JsonToXml();
        converter.convert(args[0], args[1]);
        System.out.println("Преобразование прошло успешно, результат сохранен в файл " + args[1]);
    }
}
main
