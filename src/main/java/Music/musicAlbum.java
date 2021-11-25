package Music;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class musicAlbum {
    private String album,executor,country;
    private Integer year,tracks;
    private ArrayList<String> genres;

    public musicAlbum()
    {
        genres = new ArrayList<>();
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(@NotNull String album) {
        this.album = album;
    }

    public  String getExecutor(){
        return executor;
    }

    public void setExecutor(@NotNull String executor) {
        this.executor = executor;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(@NotNull String country) {
        this.country = country;
    }

    public int getYear()
    {
        return year;
    }

    public void setYear(Integer year) {
        if (year < 0)
            throw new IllegalArgumentException("Некорректно введен год, введите заново");
        this.year = year;
    }

    public int getTracks(){
        return tracks;
    }

    public void setTracks(Integer tracks) {
        if (tracks < 0)
            throw new IllegalArgumentException("Неверное число, необходимо ввести неотрицательное число");
        this.tracks = tracks;
    }

    public ArrayList<String> getGenres() {
        return genres;
    }

    public void setGenres(@NotNull ArrayList<String> generes) {
        this.genres = generes;
    }

    public void addGenre(@NotNull String genre){
        genres.add(genre);
    }

    public void removeGenre(@NotNull String genre){
        genres.remove(genre);
    }
}


