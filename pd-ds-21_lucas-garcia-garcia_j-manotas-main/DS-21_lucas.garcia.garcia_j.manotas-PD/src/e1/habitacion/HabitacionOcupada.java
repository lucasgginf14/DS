package e1.habitacion;

import e1.Habitacion;

public class HabitacionOcupada implements HabitacionEstado {

    @Override
    public void reservar(Habitacion habitacion, String huesped) {
        throw new IllegalStateException("La habitacion ya esta ocupada");
    }

    @Override
    public void cancelar(Habitacion habitacion) {
        habitacion.setHuesped(null);
        habitacion.setEstado(new HabitacionLibre());
    }

    @Override
    public void limpiar(Habitacion habitacion, String limpiador) {
        throw new IllegalStateException("No se puede limpiar una habitacion con alguien dentro");
    }

    @Override
    public void liberar(Habitacion habitacion) {
        habitacion.setHuesped(null);
        habitacion.setEstado(new HabitacionSucia());
    }

    @Override
    public String info(Habitacion habitacion) {
        return "Ocupada por " + habitacion.getHuesped();
    }
}