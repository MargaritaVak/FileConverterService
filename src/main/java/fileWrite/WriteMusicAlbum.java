package fileWrite;

import Music.musicAlbum;
import org.jetbrains.annotations.NotNull;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class WriteMusicAlbum implements Write {
    @Override
    public void write(@NotNull Object object, @NotNull String filePath) throws IOException, XMLStreamException {
        ArrayList<musicAlbum> albums = (ArrayList<musicAlbum>) object;

        XMLOutputFactory output = XMLOutputFactory.newInstance();
        XMLStreamWriter writer = output.createXMLStreamWriter(new FileOutputStream(filePath), "UTF-8");

        writer.writeStartDocument("utf-8", "1.0");
        writer.writeStartElement("playlist");
        for (int i = 0; i < albums.size(); i++) {
            writeAlbum(writer, albums.get(i), i);
        }
        writer.writeEndElement();
        writer.writeEndDocument();
        writer.flush();
    }

    private void writeAlbum(@NotNull XMLStreamWriter writer, @NotNull musicAlbum album, int id) throws XMLStreamException {
        writer.writeStartElement("music");
        writer.writeAttribute("id", String.valueOf(id));
        writer.writeStartElement("album");
        writer.writeCharacters(album.getAlbum());
        writer.writeEndElement();
        writer.writeStartElement("executor");
        writer.writeCharacters(album.getExecutor());
        writer.writeEndElement();
        writer.writeStartElement("year");
        writer.writeCharacters(Integer.toString(album.getYear()));
        writer.writeEndElement();
        writer.writeStartElement("country");
        writer.writeCharacters(album.getCountry());
        writer.writeEndElement();
        writer.writeStartElement("tracks");
        writer.writeCharacters(Integer.toString(album.getTracks()));
        writer.writeEndElement();
        writeGenres(writer, album);
        writer.writeEndElement();
    }

    private void writeGenres(@NotNull XMLStreamWriter writer, @NotNull musicAlbum album) throws XMLStreamException {
        writer.writeStartElement("genres");
        for (String genre : album.getGenres()) {
            writer.writeStartElement("genre");
            writer.writeCharacters(genre);
            writer.writeEndElement();
        }
        writer.writeEndElement();
    }
}
