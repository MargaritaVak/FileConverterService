package Music;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class musicCountry {
    private String name;
    private ArrayList<musicAlbum> albums;

    public musicCountry() {
        albums = new ArrayList<>();
    }

    public String getName(){
        return name;
    }

    public void setName(@NotNull String name) {
        this.name = name;
    }

    public ArrayList<musicAlbum> getAlbums() {
        return albums;
    }

    public void setAlbums(@NotNull ArrayList<musicAlbum> albums) {
        this.albums = albums;
    }

    public void addAlbums(@NotNull musicAlbum album)
    {
        albums.add(album);
    }

    public void removeAlbums(@NotNull musicAlbum album){
        albums.remove(album);
    }
}
