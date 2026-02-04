package e4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MesaBillarTest {

    private static MesaBillar mesa;

    @BeforeEach
    void setUp() {
        mesa = new MesaBillar();
        mesa.iniciarPartida();
    }

    @Test
    void testInicio() {
        assertEquals(mesa.bolasMesa().size(), 16);
        assertEquals(mesa.bolasCajetin().size(), 0);
        assertEquals(mesa.obtenerGanador(), "Empate");

        mesa.meterBola(BolaBillar.BLANCA);
        assertEquals(mesa.bolasMesa().size(), 16);
        assertEquals(mesa.bolasCajetin().size(), 0);

        assertTrue(mesa.esPartidaIniciada());
    }

    @Test
    void testMeterBolas() {
        mesa.meterBola(BolaBillar.BOLA2);
        mesa.meterBola(BolaBillar.BOLA3);
        mesa.meterBola(BolaBillar.BOLA4);
        mesa.meterBola(BolaBillar.BOLA5);

        mesa.meterBola(BolaBillar.BOLA13);
        mesa.meterBola(BolaBillar.BOLA14);

        assertEquals(mesa.obtenerGanador(), "Lisas");
    }

    @Test
    void testBolasMetidas() {
        mesa.meterBola(BolaBillar.BLANCA);
        mesa.meterBola(BolaBillar.BLANCA);
        mesa.meterBola(BolaBillar.BLANCA);

        mesa.meterBola(BolaBillar.BOLA5);

        assertEquals(mesa.bolasCajetin().size(), 1);
    }
}