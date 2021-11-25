package fileRead;

import Music.musicAlbum;
import Music.musicCountry;
import org.jetbrains.annotations.NotNull;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class ReadMusicCountry implements Read {
    @Override
    public @NotNull Object read(@NotNull String fileName) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        FileReader reader = new FileReader(fileName);
        JSONObject document = (JSONObject) parser.parse(reader);
        return getCountries (document);
    }

    private @NotNull ArrayList<musicCountry> getCountries(@NotNull JSONObject document) {
        ArrayList<musicCountry> countries = new ArrayList<>();

        JSONArray countriesJson = (JSONArray) document.get("countries");
        for (Object countryJson : countriesJson) {
            JSONObject countryData = (JSONObject) countryJson;
            JSONObject countryParameters = (JSONObject) countryData.get("country");
            musicCountry country = getCountry (countryParameters);
            CountryInMusic(country);
            countries.add(country);
        }

        return countries ;
    }

    private @NotNull musicCountry getCountry(@NotNull JSONObject countryParameters ) {
        musicCountry country = new musicCountry();

        country.setName(countryParameters.get("name").toString());
        JSONArray albumJson = (JSONArray) countryParameters.get("albums");
        ArrayList<musicAlbum> albums = getAlbums(albumJson);
        country.setAlbums(albums);

        return country;
    }


    private void CountryInMusic(@NotNull musicCountry country) {
        ArrayList<musicAlbum> albums = country.getAlbums();
        for (musicAlbum album : albums) {
            album.setCountry(country.getName());
        }
    }

    private @NotNull ArrayList<musicAlbum> getAlbums(@NotNull JSONArray albumsJson) {
        ArrayList<musicAlbum> albums = new ArrayList<>();

        for (Object albumJson : albumsJson) {
            JSONObject albumData = (JSONObject) albumJson;
           musicAlbum album = getAlbum(albumData);
            albums.add(album);
        }
        return albums;
    }

    private @NotNull musicAlbum  getAlbum(@NotNull JSONObject albumData) {
        musicAlbum album = new musicAlbum();
        album.setAlbum(albumData.get("name").toString());
        album.setExecutor(albumData.get("executor").toString());
        album.setYear(Integer.parseInt(albumData.get("year").toString()));
        album.setTracks(Integer.parseInt(albumData.get("tracks").toString()));
        JSONArray genresJson = (JSONArray) albumData.get("genres");
        setGenresToAlbum(genresJson, album);
        return album;
    }

    private void setGenresToAlbum(@NotNull JSONArray genresJson, @NotNull musicAlbum album) {
        ArrayList<String> genres = new ArrayList<>();
        for (Object genre: genresJson) {
            genres.add(genre.toString());
        }
        album.setGenres(genres);
    }
}
