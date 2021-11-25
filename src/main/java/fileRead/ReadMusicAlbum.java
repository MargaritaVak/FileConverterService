package fileRead;

import Music.musicAlbum;
import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;



import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

public class ReadMusicAlbum {
    public @NotNull Object read(@NotNull String fileName) throws IOException, SAXException, ParserConfigurationException {
        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = documentBuilder.parse(fileName);
        return getAlbums(document);
    }

    private @NotNull ArrayList<musicAlbum> getAlbums(@NotNull Document document) {
        ArrayList<musicAlbum> albums = new ArrayList<>();

        Node doc = document.getDocumentElement();
        NodeList albumNodes = doc.getChildNodes();
        for (int i = 0; i < albumNodes.getLength(); i++) {
            Node albumNode = albumNodes.item(i);
            if (albumNode.getNodeType() != Node.TEXT_NODE) {
                musicAlbum album = getAlbum(albumNode);
                albums.add(album);
            }
        }
        return albums;
    }

    private @NotNull musicAlbum getAlbum(@NotNull Node albumNode) {
        musicAlbum album = new musicAlbum();
        NodeList albumDescription= albumNode.getChildNodes();
        for (int i = 0; i < albumDescription.getLength(); i++) {
            Node albumParameter= albumDescription.item(i);
            if (albumParameter.getNodeType() != Node.TEXT_NODE) {
                switch (albumParameter.getNodeName()) {
                    case "album" -> album.setAlbum(albumParameter.getTextContent());
                    case "executor" -> album.setExecutor(albumParameter.getTextContent());
                    case "year" -> album.setYear(Integer.parseInt(albumParameter.getTextContent()));//?
                    case "country" -> album.setCountry(albumParameter.getTextContent());
                    case "tracks" -> album.setTracks(Integer.parseInt(albumParameter.getTextContent()));
                    case "genres" -> setGenresToAlbum(albumParameter, album);
                }
            }
        }
        return album;
    }

    private void setGenresToAlbum(@NotNull Node albumParameter, @NotNull musicAlbum album) {
        ArrayList<String> genres = new ArrayList<>();
        NodeList genresNode = albumParameter.getChildNodes();
        for (int i = 0; i < genresNode.getLength(); i++) {
            Node genreNode = genresNode.item(i);
            if (genreNode.getNodeType() != Node.TEXT_NODE) {
                genres.add(genreNode.getTextContent());
            }
        }
        album.setGenres(genres);
    }

}
