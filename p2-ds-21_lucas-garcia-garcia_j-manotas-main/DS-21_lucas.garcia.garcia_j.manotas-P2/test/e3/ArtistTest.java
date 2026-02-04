package e3;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ArtistTest {

    @Test
    void getters() {
        Artist artist = new Artist("Ester Queiro", "#23476EsterQueiro", Artist.Type.PERSON, Gender.FEMALE, "Galicia");

        assertEquals(artist.getName(), "Ester Queiro");
        assertEquals(artist.getId(), "#23476EsterQueiro");
        assertEquals(artist.getType(), Artist.Type.PERSON);
        assertEquals(artist.getGender(), Gender.FEMALE);
        assertEquals(artist.getArea(), "Galicia");
    }

    @Test
    void ratings() {
        assertThrows(IllegalArgumentException.class, () -> new Rating(-1));
        assertThrows(IllegalArgumentException.class, () -> new Rating(123));

        Artist artist = new Artist("Elvis Tech", "#234523ElvisTech", Artist.Type.PERSON, Gender.MALE, "USA");

        artist.addRating(new Rating(4));
        artist.addRating(new Rating(3));
        artist.addRating(new Rating(3));
        artist.addRating(new Rating(2));
        artist.addRating(new Rating(2));

        assertEquals(artist.getBestRating(), new Rating(4));
        assertEquals(artist.getWorstRating(), new Rating(2));
        assertEquals(artist.getAverageRating(), new Rating(2.8f));
    }

    @Test
    void comparaison() {
        Artist artistA = new Artist("Paulaner", "#9384Paulaner", Artist.Type.GROUP, Gender.NEITHER, "Berlin");
        Artist artistB = new Artist("Paulaner", "#9384Paulaner", Artist.Type.GROUP, Gender.NEITHER, "Berlin");
        Artist artistC = new Artist("Orquesta sinfonica de Austria", "#31415OrquestasinfonicadeAustria", Artist.Type.ORCHESTRA, Gender.NEITHER, "Austria");

        assertEquals(artistA.compareTo(artistB), 0);
        assertNotEquals(artistA.compareTo(artistC), 0);
    }

    @Test
    void testComparators() {
        Artist a = new Artist("Elvis Tech", "#234523ElvisTech", Artist.Type.PERSON, Gender.MALE, "USA");
        Artist b = new Artist("Paulaner", "#9384Paulaner", Artist.Type.GROUP, Gender.NEITHER, "Berlin");

        a.addGender(MusicGender.ROCK);
        a.addGender(MusicGender.POP);
        a.addGender(MusicGender.TECHNO); // Asi comprobamos tambien que no se añaden duplicados
        a.addGender(MusicGender.TECHNO);
        a.addGender(MusicGender.TECHNO);

        b.addGender(MusicGender.BLUES);
        b.addGender(MusicGender.CLASICA);
        b.addGender(MusicGender.JAZZ);
        b.addGender(MusicGender.COUNTRY);

        ArrayList<Artist> artists = new ArrayList<>();
        artists.add(a);
        artists.add(b);

        artists.sort(Artist.eclecticismComparator);
        assertEquals(a.compareTo(artists.get(0)), 0);

        assertThrows(IllegalStateException.class, a::getWorstRating);
        assertThrows(IllegalStateException.class, a::getBestRating);

        a.addRating(new Rating(2));
        a.addRating(new Rating(2));
        a.addRating(new Rating(2));

        b.addRating(new Rating(1));
        b.addRating(new Rating(4));
        b.addRating(new Rating(5));

        artists.sort(Artist.worstRatingComparator);
        assertEquals(b.compareTo(artists.get(0)), 0);

        artists.sort(Artist.bestRatingComparator);
        assertEquals(a.compareTo(artists.get(0)), 0);

        artists.sort(Artist.averageRatingComparator);
        assertEquals(a.compareTo(artists.get(0)), 0);
    }
}