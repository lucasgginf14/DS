package e1.habitacion;

import e1.Habitacion;

public class HabitacionSucia implements HabitacionEstado {

    @Override
    public void reservar(Habitacion habitacion, String huesped) {
        throw new IllegalStateException("No se puede reservar una habitacion sucia");
    }

    @Override
    public void cancelar(Habitacion habitacion) {
        throw new IllegalStateException("No se puede cancelar la reserva de una habitacion no disponible para ser reservada");
    }

    @Override
    public void limpiar(Habitacion habitacion, String limpiador) {
        habitacion.setEstado(new HabitacionLibre());
    }

    @Override
    public void liberar(Habitacion habitacion) {
        throw new IllegalStateException("No se puede liberar una habitacion ya liberada");
    }

    @Override
    public String info(Habitacion habitacion) {
        return "Libre pendiente de limmpieza";
    }
}