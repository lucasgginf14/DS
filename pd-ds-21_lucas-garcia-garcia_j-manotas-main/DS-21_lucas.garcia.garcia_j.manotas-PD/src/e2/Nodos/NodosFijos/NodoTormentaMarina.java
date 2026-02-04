package e2.Nodos.NodosFijos;

import e2.Flota;
import e2.Nodos.Nodo;
import e2.Nodos.NodosFijos.NodoRutaFija;

public class NodoTormentaMarina extends NodoRutaFija {

    private final int fuerza;
    final int PODER = 10;

    public NodoTormentaMarina(String nombre, Nodo siguiente, int fuerza){
        super(nombre, siguiente);
        this.fuerza = fuerza;
    }

    @Override
    public void Accion(Flota flota) {
        if (flota.getVision() < fuerza)
            flota.recibir(PODER);

        flota.siguienteNodo(getSiguiente());
    }

    @Override
    public int minNumNodosParaterminar() {
        return 1 + getSiguiente().minNumNodosParaterminar();
    }

    @Override
    public String toString() {
        return "(" + getNombre() + " Tormenta Marina, " + getSiguiente().toString() + ")";
    }
}