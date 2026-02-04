package e4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class BolaBillarTest {

    @Test
    void testEquals() {
        assertEquals(BolaBillar.BOLA14.getTipo(), TipoBola.RAYADA);
        assertEquals(BolaBillar.BOLA4.getTipo(), TipoBola.LISA);
        assertEquals(BolaBillar.BOLA8.getTipo(), TipoBola.LISA);

        assertEquals(BolaBillar.BOLA6.getColor(), "VERDE");
        assertEquals(BolaBillar.BOLA11.getColor(), "ROJO");
    }

    @Test
    void testNotEquals() {
        assertNotEquals(BolaBillar.BOLA5.getTipo(), BolaBillar.BOLA13.getTipo());
        assertNotEquals(BolaBillar.BOLA2.getColor(), BolaBillar.BOLA12.getColor());
    }
}