package e2.Nodos;

public abstract class Nodo implements EventoNodo {
    private final String nombre;
    public String getNombre(){ return nombre;}

    public Nodo(String nombre){
        this.nombre = nombre;
    }

    public abstract int minNumNodosParaterminar();
}