package e3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;

public class Release {

    private final String id;
    private String artist;
    private String title;
    private final ArrayList<Track> tracks;

    public Release(String id) {
        this.id = id;
        tracks = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist){
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void addTrack(Track track) {
        // Insertamos en la lista de forma ordenada para facilitar las comparaciones
        for (int i = 0; i < tracks.size(); i++)
            if (track.compareTo(tracks.get(i)) < 0) {
                tracks.add(i, track);
                return;
            }

        tracks.add(track);
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Release r))
            return false;

        if (tracks.size() != r.tracks.size())
            return false;

        for (int i = 0; i < tracks.size(); i++)
            if(!tracks.get(i).equals(r.tracks.get(i)))
                return false;

        return true;
    }

    @Override
    public int hashCode(){
        return Objects.hash(tracks);
    }
}