package e2.Nodos.NodosBifurcacion;

import e2.Flota;
import e2.Nodos.Nodo;

public class NodoBatalla extends NodoBifurcacion {

    private final Flota flota;

    public NodoBatalla(String nombre, Nodo izquierdo, Nodo derecho, Flota flota){
        super(nombre, izquierdo, derecho);
        this.flota = flota;
    }

    @Override
    public void Accion(Flota flota) {
        flota.atacarMutuamente(this.flota);
        flota.siguienteNodo(this.flota.getHp() <= 0 ? getIzquierdo() : getDerecho());
    }

    @Override
    public int minNumNodosParaterminar() {
        return 1 + Math.min(getIzquierdo().minNumNodosParaterminar(), getDerecho().minNumNodosParaterminar());
    }

    @Override
    public String toString() {
        return "(" + getNombre() + " Batalla, " + getIzquierdo().toString() + ", " + getDerecho().toString() + ")";
    }
}
