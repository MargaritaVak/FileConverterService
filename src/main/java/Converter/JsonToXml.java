json_to_xml
package Converter;

import Music.musicAlbum;
import Music.musicCountry;
import extension.fileExtension;
import fileRead.ReadMusicCountry;
import fileWrite.WriteMusicAlbum;
import org.jetbrains.annotations.NotNull;
import org.json.simple.parser.ParseException;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;

import java.util.ArrayList;

public class JsonToXml  implements FileConverter {

   @Override
    public void convert(@NotNull String jsonFileName, @NotNull String xmlFileName) throws IOException, ParseException, XMLStreamException{
        if (!fileExtension.getExtension(xmlFileName).equals("xml")) {
           throw new IllegalArgumentException("Неверное расширение файла");
    }

  ReadMusicCountry reader = new ReadMusicCountry();
    ArrayList<musicCountry> countries = (ArrayList<musicCountry>) reader.read("file/input/" + jsonFileName);
    ArrayList<musicAlbum> albums = convertJsonToXml(countries);

    WriteMusicAlbum writer = new WriteMusicAlbum();
    writer.write(albums, "file/output/" + xmlFileName);
}

private @NotNull ArrayList<musicAlbum> convertJsonToXml(@NotNull ArrayList<musicCountry> countries) {
    ArrayList<musicAlbum> albums = new ArrayList<>();

    for (musicCountry country : countries) {
        ArrayList<musicAlbum> countryAlbum = country.getAlbums();
        albums.addAll(countryAlbum);
    }
    return albums;
}
}
=======
package Converter;

import Music.musicAlbum;
import Music.musicCountry;
import extension.fileExtension;
import fileRead.ReadMusicCountry;
import fileWrite.WriteMusicAlbum;
import org.jetbrains.annotations.NotNull;
import org.json.simple.parser.ParseException;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;

import java.util.ArrayList;

public class JsonToXml  implements FileConverter {

   @Override
    public void convert(@NotNull String jsonFileName, @NotNull String xmlFileName) throws IOException, ParseException, XMLStreamException{
        if (!fileExtension.getExtension(xmlFileName).equals("xml")) {
           throw new IllegalArgumentException("Неверное расширение файла");
    }

  ReadMusicCountry reader = new ReadMusicCountry();
    ArrayList<musicCountry> countries = (ArrayList<musicCountry>) reader.read("file/input/" + jsonFileName);
    ArrayList<musicAlbum> albums = convertJsonToXml(countries);

    WriteMusicAlbum writer = new WriteMusicAlbum();
    writer.write(albums, "file/output/" + xmlFileName);
}

private @NotNull ArrayList<musicAlbum> convertJsonToXml(@NotNull ArrayList<musicCountry> countries) {
    ArrayList<musicAlbum> albums = new ArrayList<>();

    for (musicCountry country : countries) {
        ArrayList<musicAlbum> countryAlbum = country.getAlbums();
        albums.addAll(countryAlbum);
    }
    return albums;
}
}

main