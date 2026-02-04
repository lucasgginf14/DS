package e3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class Artist implements Comparable<Artist> {

    private final String name;
    public String getName(){
        return name;
    }

    private final String id;
    public String getId(){
        return id;
    }

    public enum Type {
        PERSON, GROUP, ORCHESTRA, CHOIR, CHARACTER, OTHER
    }
    private final Type type;
    public Type getType(){
        return type;
    }

    private final Gender gender;
    public Gender getGender(){
        return gender;
    }

    private final String area;
    public String getArea(){
        return area;
    }

    private final ArrayList<Rating> ratings = new ArrayList<>();
    public void addRating(Rating rating) {
        ratings.add(rating);
    }

    public Rating getAverageRating() {
        float sum = 0;
        for (Rating r : ratings)
            sum += r.stars();
        return new Rating(sum / ratings.size());
    }
    public Rating getBestRating() {
        if (ratings.isEmpty())
            throw new IllegalStateException("Lista vacia");

        Collections.sort(ratings);
        return ratings.get(ratings.size() - 1);
    }
    public Rating getWorstRating() {
        if (ratings.isEmpty())
            throw new IllegalStateException("Lista vacia");

        Collections.sort(ratings);
        return ratings.get(0);
    }

    private final HashSet<MusicGender> genders = new HashSet<>();
    public void addGender(MusicGender gender) {
        genders.add(gender);
    }

    public Artist(String name, String id, Type type, Gender gender, String area){
        this.name = name;
        this.id = id;
        this.type = type;
        this.gender = gender;
        this.area = area;
    }

    @Override
    public int compareTo(Artist artist) {
        return id.compareTo(artist.id);
    }

    public static Comparator<Artist> averageRatingComparator = (a1, a2) -> a1.getAverageRating().compareTo(a2.getAverageRating());
    public static Comparator<Artist> eclecticismComparator = (a1, a2) -> a1.genders.size() - a2.genders.size();
    public static Comparator<Artist> bestRatingComparator = (a1, a2) -> a1.getBestRating().compareTo(a2.getBestRating());
    public static Comparator<Artist> worstRatingComparator = (a1, a2) -> a1.getWorstRating().compareTo(a2.getWorstRating());
}