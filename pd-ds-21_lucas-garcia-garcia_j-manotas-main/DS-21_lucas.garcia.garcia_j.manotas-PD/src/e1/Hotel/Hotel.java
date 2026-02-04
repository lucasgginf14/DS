package e1.Hotel;

import e1.Habitacion;
import e1.habitacion.HabitacionSucia;

import java.util.ArrayList;
import java.util.HashMap;

public class Hotel {

    private final String nombre;
    public String getNombre() {return nombre;}

    private int numHabitaciones = 0;

    private final HashMap<Integer, Habitacion> habitacionesDisponibles = new HashMap<>();
    private final HashMap<Integer, Habitacion> habitacionesOcupadas = new HashMap<>();
    private final HashMap<Integer, Habitacion> habitacionesSucias = new HashMap<>();

    // La propia clase hotel es la que se encarga de diferenciar de las habitaciones libres las que estan aprobadas y las que no
    // para no tener que añadir un estado que sea muy parecido al "libre"
    private final HashMap<Integer, Habitacion> habitacionesPendientes = new HashMap<>();;

    public Hotel(String nombre, int numHabitaciones) {
        this.nombre = nombre;
        for (int i = 0; i < numHabitaciones; i++)
            anadirHabitacion();
    }

    public void anadirHabitacion() {
        numHabitaciones++;
        habitacionesDisponibles.put(numHabitaciones, new Habitacion(numHabitaciones));
    }

    public void reservarHabitacion(int numero, String huesped){
        if (!habitacionesDisponibles.containsKey(numero))
            throw new IllegalStateException("No se puede reservar la habitacion " + numero);

        Habitacion h = habitacionesDisponibles.remove(numero);
        h.reservar(huesped);
        habitacionesOcupadas.put(numero, h);
    }

    public void terminarReserva(int numero) {
        if (!habitacionesOcupadas.containsKey(numero))
            throw new IllegalStateException("No se puede cancelar la reserva de la habitacion " + numero);

        Habitacion h = habitacionesOcupadas.remove(numero);
        h.terminarReserva();
        habitacionesDisponibles.put(numero, h);
    }

    public void liberarHabitacion(int numero) {
        if (!habitacionesOcupadas.containsKey(numero))
            throw new IllegalStateException("No se puede liberar la habitacion " + numero);

        Habitacion h = habitacionesOcupadas.remove(numero);
        h.liberar();
        habitacionesSucias.put(numero, h);
    }

    public void limpiarHabitacion(int numero, String limpiador) {
        if (!habitacionesSucias.containsKey(numero))
            throw new IllegalArgumentException("No se puede limpiar la habitacion " + numero);

        Habitacion h = habitacionesSucias.remove(numero);
        h.limpiar(limpiador);
        habitacionesPendientes.put(numero, h);
    }

    public void aprobarLimpieza(int numero, boolean aprobada, String supervisor){
        if (!habitacionesPendientes.containsKey(numero))
            throw new IllegalArgumentException("No se puede aprobar la habitacion " + numero);

        if (aprobada) {
            Habitacion habitacion = habitacionesPendientes.remove(numero);
            habitacion.setSupervisor(supervisor);
            habitacionesDisponibles.put(numero, habitacionesPendientes.remove(numero));
        }
        else {
            Habitacion habitacion = habitacionesPendientes.remove(numero);
            habitacion.setEstado(new HabitacionSucia());
            habitacionesSucias.put(numero, habitacion);
        }
    }

    public ArrayList<Habitacion> habitacionesDisponibles() {
        return new ArrayList<>(habitacionesDisponibles.values().stream().toList());
    }

    public ArrayList<Habitacion> habitacionesOcupadas() {
        return new ArrayList<>(habitacionesOcupadas.values().stream().toList());
    }

    public ArrayList<Habitacion> habitacionesPendientesDeLimpieza() {
        return new ArrayList<>(habitacionesSucias.values().stream().toList());
    }

    public ArrayList<Habitacion> habitacionesPendientesDeAprobacion() {
        return new ArrayList<>(habitacionesPendientes.values().stream().toList());
    }

    @Override
    public String toString() {
        StringBuilder separator = new StringBuilder();
        separator.append("--");
        for (var __ : nombre.toCharArray())
            separator.append("-");

        StringBuilder sb = new StringBuilder();
        sb.append(separator.toString()).append("\n");
        sb.append("|").append(nombre).append("|\n");
        sb.append(separator.toString()).append("\n");

        for (Habitacion h : habitacionesDisponibles.values())
            sb.append("|").append(h.toString()).append("\n");

        for (Habitacion h : habitacionesOcupadas.values())
            sb.append("|").append(h.toString()).append("\n");

        for (Habitacion h : habitacionesSucias.values())
            sb.append("|").append(h.toString()).append("\n");

        for (Habitacion h : habitacionesPendientes.values())
            sb.append("|").append(h.toString()).append("\n");

        return sb.toString();
    }
}