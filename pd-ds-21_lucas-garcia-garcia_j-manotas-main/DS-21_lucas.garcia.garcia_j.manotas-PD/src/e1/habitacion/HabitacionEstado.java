package e1.habitacion;

import e1.Habitacion;

public interface HabitacionEstado {

    void reservar(Habitacion habitacion, String huesped);

    void cancelar(Habitacion habitacion);

    void limpiar(Habitacion habitacion, String limpiador);

    void liberar(Habitacion habitacion);

    String info(Habitacion habitacion);
}