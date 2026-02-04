package e3;

public record Rating(float stars)  implements Comparable<Rating> {

    public Rating{
        if (stars < 0 || stars > 5)
            throw new IllegalArgumentException("Las estrellas deben estar en el intervalo [0,5]");
    }

    @Override
    public int compareTo(Rating t) {
        return Float.compare(stars, t.stars());
    }
}