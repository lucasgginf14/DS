package e2;

import e2.Nodos.Nodo;
import e2.Nodos.NodoFin;
import e2.Nodos.NodosBifurcacion.NodoAvistamiento;
import e2.Nodos.NodosBifurcacion.NodoBatalla;
import e2.Nodos.NodosFijos.NodoAtaqueAereo;
import e2.Nodos.NodosFijos.NodoTormentaMarina;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class FlotaTest extends TestCase {

    @Test
    public void testGetters() {
        Flota flota = new Flota(10, 9, 8, 7, 6);
        assertEquals(10, flota.getHp());
        assertEquals(9, flota.getBlindaje());
        assertEquals(8, flota.getpoderFuego());
        assertEquals(7, flota.getAntiaereos());
        assertEquals(6, flota.getVision());

        flota.recibir(7);
        assertEquals(3, flota.getHp());
    }

    @Test
    public void testAtaqueAereo(){
        Flota flota = new Flota(10, 3, 0, 1, 0);
        NodoFin fin = new NodoFin("final");

        NodoAtaqueAereo ataque = new NodoAtaqueAereo("Inicio", fin, 7);
        flota.setNodoActual(ataque);
        assertEquals(flota.getHp(), 8);

        flota = new Flota(12, 0, 0, 0, 5);
        fin = new NodoFin("final");

        NodoTormentaMarina tormenta = new NodoTormentaMarina("Inicio", fin, 8);
        flota.setNodoActual(tormenta);
        assertEquals(flota.getHp(), 2);
    }

    @Test
    public void testNodos() {
        NodoFin d = new NodoFin("d");
        NodoFin e = new NodoFin("e");
        NodoFin f = new NodoFin("f");

        NodoTormentaMarina b = new NodoTormentaMarina("b", d, 0);
        NodoBatalla c = new NodoBatalla("c", e, f, new Flota(2, 2, 2, 2, 2));
        NodoAvistamiento a = new NodoAvistamiento("a", b, c, 3);
        assertEquals(a.minNumNodosParaterminar(), 2);

        assertEquals(a.toString(), "(a Avistamiento, (b Tormenta Marina, (d Fin)), (c Batalla, (e Fin), (f Fin)))");
    }

    @Test
    public void testBifurcacionBatalla(){
        Flota flota = new Flota(10, 5, 7, 0, 0);

        Flota a = new Flota(3, 1, 6, 0, 0);
        Flota b = new Flota(100, 100, 100, 0, 0);

        NodoFin finA = new NodoFin("derecha"),
        finB = new NodoFin("izquierda derecha"),
        finC = new NodoFin("izquierda izquierda");

        NodoBatalla batalla2 = new NodoBatalla("Segunda batalla", finC, finB, b);
        NodoBatalla batalla1 = new NodoBatalla("Primera batala", batalla2, finA, a);

        flota.setNodoActual(batalla1);

        assertTrue(flota.getHp() < 0);
        assertTrue(a.getHp() < 0);
        assertTrue(b.getHp() > 0);

        Flota flota2 = new Flota(10, 0, 0, 0, 3);

        NodoFin fin2A = new NodoFin("izq"),
                fin2B = new NodoFin("der");

        NodoAvistamiento avistamiento = new NodoAvistamiento("Avistamiento", fin2A, fin2B, 7);
        flota2.setNodoActual(avistamiento);

        assertEquals(flota2.getNodoActual().getNombre(), "der");
    }
}