package fileWrite;

import Music.musicAlbum;
import Music.musicCountry;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WriteMusicCountry implements Write{
    @Override
    public void write(@NotNull Object object, @NotNull String filePath) throws IOException {
        ArrayList<musicCountry> countries = (ArrayList<musicCountry>) object;

        JsonObject countryObject = getCountryObject(countries);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(countryObject);

        File file = new File(filePath);
        file.createNewFile();
        FileWriter writer = new FileWriter(filePath, false);
        writer.write(json);
        writer.flush();
        writer.close();
    }

    private @NotNull JsonObject getCountryObject(@NotNull ArrayList<musicCountry> countries) {
        JsonArray jsonCountries = new JsonArray();
        for (musicCountry country : countries) {
            JsonObject jsonCountry = new JsonObject();
            jsonCountry.addProperty("name", country.getName());
            jsonCountry.add("albums", getAlbumJson(country));

            JsonObject viewObject = new JsonObject();
            viewObject.add("country", jsonCountry);
            jsonCountries.add(viewObject);
        }

        JsonObject countriesObject = new JsonObject();
        countriesObject.add("countries", jsonCountries);
        return countriesObject;
    }

    private @NotNull JsonArray getAlbumJson(@NotNull musicCountry country) {
        JsonArray jsonAlbum = new JsonArray();

        for (musicAlbum album : country.getAlbums()) {
            JsonObject albumObject = new JsonObject();
            albumObject.addProperty("name", album.getAlbum());
            albumObject.addProperty("executor", album.getExecutor());
            albumObject.addProperty("year", album.getYear());
            albumObject.addProperty("tracks", album.getTracks());
            albumObject.add("genres", getGenresJson(album));
            jsonAlbum.add(albumObject);
        }
        return jsonAlbum;
    }

    private @NotNull JsonArray getGenresJson(@NotNull musicAlbum album) {
        JsonArray jsonGenres = new JsonArray();
        for (String genre : album.getGenres()) {
            jsonGenres.add(genre);
        }
        return jsonGenres;
    }

}

