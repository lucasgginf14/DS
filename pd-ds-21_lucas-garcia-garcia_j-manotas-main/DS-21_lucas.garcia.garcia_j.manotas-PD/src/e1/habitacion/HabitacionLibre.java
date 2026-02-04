package e1.habitacion;

import e1.Habitacion;

public class HabitacionLibre implements HabitacionEstado {

    @Override
    public void reservar(Habitacion habitacion, String huesped) {
        habitacion.setHuesped(huesped);
        habitacion.setEstado(new HabitacionOcupada());
    }

    @Override
    public void cancelar(Habitacion habitacion) {
        throw new IllegalStateException("No se puede cancelar la reserva de una habitacion libre");
    }

    @Override
    public void limpiar(Habitacion habitacion, String limpiador) {
        throw new IllegalStateException("La habitacion ya esta limpia");
    }

    @Override
    public void liberar(Habitacion habitacion) {
        throw new IllegalStateException("La habitacion ya esta vacia");
    }

    @Override
    public String info(Habitacion habitacion) {
        return "Habitacion libre aprobada por " + habitacion.getSupervisor();
    }
}