package e2.Nodos;

import e2.Flota;

public class NodoFin extends Nodo {

    public NodoFin (String nombre){
        super(nombre);
    }

    @Override
    public int minNumNodosParaterminar() {
        return 0;
    }

    @Override
    public void Accion(Flota flota) {
        String sb = "Resultado:\n" +
                "\t" + (flota.getHp() > 0 ? "SUCCES\n" : "FAIL\n") +
                "\tUltimo nodo visitado: " + flota.getNodoAnterior().getNombre() + "\n" +
                "\t Vida final" + flota.getHp();
        flota.setResultadoFinal(sb);
    }

    @Override public String toString() {
        return "(" + getNombre() + " Fin)";
    }
}