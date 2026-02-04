package e2.Nodos.NodosFijos;

import e2.Nodos.Nodo;

public abstract class NodoRutaFija extends Nodo {

    private Nodo siguiente;
    public Nodo getSiguiente(){ return siguiente; }

    public NodoRutaFija(String nombre, Nodo siguiente) {
        super(nombre);
        this.siguiente = siguiente;
    }
}