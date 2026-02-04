package e2.Nodos.NodosBifurcacion;

import e2.Flota;
import e2.Nodos.Nodo;

public class NodoAvistamiento extends NodoBifurcacion {

    private final int distanciaPunto;

    public NodoAvistamiento(String nombre, Nodo izquierdo, Nodo derecho, int distanciaPunto){
        super(nombre, izquierdo, derecho);
        this.distanciaPunto = distanciaPunto;
    }

    @Override
    public void Accion(Flota flota) {
        flota.siguienteNodo(flota.getVision() >= distanciaPunto ? getIzquierdo() : getDerecho());
    }

    @Override
    public int minNumNodosParaterminar() {
        return 1 + Math.min(getIzquierdo().minNumNodosParaterminar(), getDerecho().minNumNodosParaterminar());
    }

    @Override
    public String toString() {
        return "(" + getNombre() + " Avistamiento, " + getIzquierdo().toString() + ", " + getDerecho().toString() + ")";
    }
}