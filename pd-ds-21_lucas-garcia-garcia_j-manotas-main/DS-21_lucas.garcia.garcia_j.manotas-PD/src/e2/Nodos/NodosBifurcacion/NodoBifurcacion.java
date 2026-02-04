package e2.Nodos.NodosBifurcacion;

import e2.Nodos.Nodo;

public abstract class NodoBifurcacion extends Nodo {

    private Nodo izquierdo;
    public Nodo getIzquierdo(){ return izquierdo; }

    private Nodo derecho;
    public Nodo getDerecho(){ return derecho; }

    public NodoBifurcacion(String nombre, Nodo izquierdo, Nodo derecho){
        super(nombre);
        this.izquierdo = izquierdo;
        this.derecho = derecho;
    }
}