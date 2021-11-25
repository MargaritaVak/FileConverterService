package Converter;

import Music.musicAlbum;
import Music.musicCountry;
import extension.fileExtension;
import fileRead.ReadMusicAlbum;
import fileWrite.WriteMusicCountry;
import org.jetbrains.annotations.NotNull;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

public class XmlToJson implements FileConverter{
    @Override
    public void convert(String xmlFileName,String jsonFileName) throws IOException, ParserConfigurationException, SAXException {
        if (!fileExtension.getExtension(jsonFileName).equals("json")) {
            throw new IllegalArgumentException("Неверное расширение файла");
        }
        ReadMusicAlbum reader = new ReadMusicAlbum();
        ArrayList<musicAlbum> albums = (ArrayList<musicAlbum>) reader.read("file/input/" + xmlFileName);
        ArrayList<musicCountry> countries = convertXmlToJson(albums);
        WriteMusicCountry writer = new  WriteMusicCountry();
        writer.write(countries, "file/input/" + jsonFileName);

    }

    private @NotNull ArrayList<musicCountry> convertXmlToJson(@NotNull ArrayList<musicAlbum> albums) {
        ArrayList<musicCountry> countries = new ArrayList<>();
        for (musicAlbum album : albums) {
            musicCountry country = new musicCountry();
            country.setName(album.getCountry());
            if (containsMusicCountry(countries, country.getName())) continue;
            ArrayList<musicAlbum> countryAlbum = new ArrayList<>();
            for (musicAlbum album1 : albums) {
                if (album1.getCountry().equals(country.getName())) {
                    countryAlbum.add(album1);
                }
            }
            country.setAlbums(countryAlbum);
            countries.add(country);
        }

        return countries;
    }
    private boolean containsMusicCountry(@NotNull ArrayList<musicCountry> countries, @NotNull String countryName) {
        for (musicCountry country : countries) {
            if (country.getName().equals(countryName)) {
                return true;
            }
        }
        return false;
    }
}
