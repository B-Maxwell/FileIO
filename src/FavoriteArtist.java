/**
 * Created by MacbookStudioPro on 2/8/17.
 */
public class FavoriteArtist {

    String name;
    String album;
    String song;
    String genre;
    boolean onTour;

    public FavoriteArtist(){}

    public FavoriteArtist(String name, String album, String song, String genre, boolean onTour) {
        this.name = name;
        this.album = album;
        this.song = song;
        this.genre = genre;
        this.onTour = onTour;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public boolean isOnTour() {
        return onTour;
    }

    public void setOnTour(boolean onTour) {
        this.onTour = onTour;
    }

    @Override
    public String toString() {
        return "Favorite Artist Survey Info:" +
                "Favorite Artist Name:" + name + '\n' +
                "Favorite Album:" + album + '\n' +
                "Favorite Song:" + song + '\n' +
                "Favorite Artist Genre:" + genre + '\n' +
                "Favorite Artist On Tour?" + onTour;
    }
}
