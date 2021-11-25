package extension;

import java.io.FileNotFoundException;
import java.io.IOException;

public class fileExtension {
    public static String getExtension(String fileName) throws IOException
   {
        if (fileName.indexOf('.') < 0 || fileName.indexOf('.') == fileName.length() - 1) {
            throw new FileNotFoundException("Неверно введено имя файла");
        }

        return fileName.substring(fileName.lastIndexOf('.') + 1);
    }
}
