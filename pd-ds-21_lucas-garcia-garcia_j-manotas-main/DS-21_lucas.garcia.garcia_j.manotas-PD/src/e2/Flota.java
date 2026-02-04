package e2;

import e2.Nodos.Nodo;
import e2.Nodos.NodoFin;

public class Flota {
    private int hp;
    public int getHp(){ return hp;}
    public void recibir(int cantidad) {
        hp -= Math.max(cantidad, 0);
    }
    public void atacarMutuamente(Flota flota) {
        flota.recibir(poderFuego - flota.blindaje);
        recibir(flota.poderFuego - blindaje);
    }

    private final int blindaje;
    public int getBlindaje(){ return blindaje;}

    private final int poderFuego;
    public int getpoderFuego(){ return poderFuego;}

    private final int antiaereos;
    public int getAntiaereos(){ return antiaereos;}

    private final int vision;
    public int getVision() { return vision;}

    private Nodo nodoAnterior = null;
    public Nodo getNodoAnterior(){return nodoAnterior; }

    private Nodo nodoActual = null;
    public Nodo getNodoActual(){ return nodoActual;}
    public void siguienteNodo(Nodo siguiente){
        if (hp <= 0)
            setNodoActual(new NodoFin("Derrota"));
        else
            setNodoActual(siguiente);
    }
    public void setNodoActual(Nodo nodoActual) {
        nodoAnterior = this.nodoActual;
        this.nodoActual = nodoActual;
        nodoActual.Accion(this);
    }

    private String resultadoFinal;
    public String getResultadoFinal(){ return resultadoFinal; }
    public void setResultadoFinal(String str){
        this.resultadoFinal = str;
    }

    public Flota(int hp, int blindaje, int poderFuego, int antiaereos, int vision) {
        this.hp = hp;
        this.blindaje = blindaje;
        this.poderFuego = poderFuego;
        this.antiaereos = antiaereos;
        this.vision = vision;
    }
}