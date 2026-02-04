package e3;

public record Track(String pos, String recording, String nombreGrupo , String nombreCancion, int duracion) implements Comparable<Track> {

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (!(obj instanceof Track t))
            return false;

        return recording.equals(t.recording);

    }

    @Override
    public int hashCode() {
        return recording.hashCode();
    }

    @Override
    public int compareTo(Track t) {
        return recording.compareTo(t.recording);
    }
}