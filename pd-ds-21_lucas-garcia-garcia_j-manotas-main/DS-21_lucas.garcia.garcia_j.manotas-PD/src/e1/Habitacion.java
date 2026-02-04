package e1;

import e1.habitacion.HabitacionEstado;
import e1.habitacion.HabitacionLibre;

public class Habitacion {

    private final int numero;
    public int getNumero() {return numero;}

    private String huesped;
    public void setHuesped(String huesped) {this.huesped = huesped;}
    public String getHuesped() {return huesped;}

    private String supervisor = "el director del hotel";
    public void setSupervisor(String supervisor) {this.supervisor = supervisor;}
    public String getSupervisor() {return supervisor;}

    private String limpiador;
    public String getLimpiador() {return limpiador;}

    private HabitacionEstado estado;
    public void setEstado(HabitacionEstado estado) {
        this.estado = estado;
    }

    public Habitacion(int numero) {
        this.numero = numero;
        huesped = null;
        estado = new HabitacionLibre();
    }

    public void reservar(String huesped) {
        estado.reservar(this, huesped);
    }

    public void terminarReserva() {
        estado.cancelar(this);
    }

    public void limpiar(String limpiador) {
        this.limpiador = limpiador;
        estado.limpiar(this, limpiador);
    }

    public void liberar() {
        estado.liberar(this);
    }

    @Override
    public String toString() {
        return "Habitacion " + numero + ": " + estado.info(this);
    }
}