package e1.Hotel;

import e1.Habitacion;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HotelTest {

    @Test
    void testReservas() {
        Hotel transilvania = new Hotel("Hotel transilvania", 100);

        transilvania.reservarHabitacion(1, "Dracula");
        transilvania.reservarHabitacion(2, "Pepa");
        assertThrows(IllegalStateException.class, () -> transilvania.reservarHabitacion(0, "Juan"));
        assertEquals(transilvania.habitacionesDisponibles().size(), 98);
        assertEquals(transilvania.habitacionesOcupadas().size(), 2);
        transilvania.terminarReserva(1);
        transilvania.terminarReserva(2);
        assertEquals(transilvania.habitacionesDisponibles().size(), 100);
    }

    @Test
    void testLimpieza() {
        Hotel budapest = new Hotel("Budapest", 10);
        budapest.anadirHabitacion();
        budapest.reservarHabitacion(11, "Peter");
        budapest.liberarHabitacion(11);

        assertEquals(budapest.habitacionesPendientesDeLimpieza().size(), 1);

        budapest.limpiarHabitacion(11, "Felipe");
        assertEquals(budapest.habitacionesPendientesDeAprobacion().size(), 1);

        budapest.aprobarLimpieza(11, false, "Jose");
        budapest.limpiarHabitacion(11, "Julian");
        budapest.aprobarLimpieza(11, true, "Jose");
        assertEquals(budapest.habitacionesDisponibles().size(), 11);
    }

    @Test
    void string() {
        Hotel fic = new Hotel("Fic5Estrellas", 6);
        fic.reservarHabitacion(1, "Mario");
        fic.reservarHabitacion(2, "Jacobo");
        fic.liberarHabitacion(2);
        fic.reservarHabitacion(3, "Brais");
        fic.liberarHabitacion(3);
        fic.limpiarHabitacion(3, "Pedro");

        String resultadoEsperado = """
                ---------------
                |Fic5Estrellas|
                ---------------
                |Habitacion 4: Habitacion libre aprobada por el director del hotel
                |Habitacion 5: Habitacion libre aprobada por el director del hotel
                |Habitacion 6: Habitacion libre aprobada por el director del hotel
                |Habitacion 1: Ocupada por Mario
                |Habitacion 2: Libre pendiente de limmpieza
                |Habitacion 3: Habitacion libre aprobada por el director del hotel
                """;

        assertEquals(fic.toString(), resultadoEsperado);
    }
}