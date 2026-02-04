package e2.Nodos.NodosFijos;

import e2.Flota;
import e2.Nodos.Nodo;
import e2.Nodos.NodosFijos.NodoRutaFija;

public class NodoAtaqueAereo extends NodoRutaFija {

    private int poder;

    public NodoAtaqueAereo(String nombre, Nodo siguiente, int poder){
        super(nombre, siguiente);
        this.poder = poder;
    }

    @Override
    public void Accion(Flota flota) {
        flota.recibir(poder - (2 * flota.getAntiaereos() + flota.getBlindaje()));
        flota.siguienteNodo(getSiguiente());
    }

    @Override
    public int minNumNodosParaterminar() {
        return 1 + getSiguiente().minNumNodosParaterminar();
    }

    @Override
    public String toString() {
        return "(" + getNombre() + " Ataque Aereo, " + getSiguiente().toString() + ")";
    }
}
