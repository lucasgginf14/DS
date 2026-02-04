package e4;

import java.util.ArrayList;
import java.util.Arrays;

public class MesaBillar {

    private final ArrayList<BolaBillar> bolasMesa;
    private final ArrayList<BolaBillar> bolasCajetin;

    private boolean partidaIniciada = false;
    private int metidasLisas, metidasRayadas;

    public MesaBillar() {
        bolasMesa = new ArrayList<>();
        bolasMesa.addAll(Arrays.asList(BolaBillar.values()));
        bolasCajetin= new ArrayList<>();
    }

    public void iniciarPartida() {
        partidaIniciada = true;

        for (int i = bolasCajetin.size() - 1; i >= 0; i--) {
            BolaBillar b = bolasCajetin.get(i);
            bolasCajetin.remove(i);
            bolasMesa.add(b);
        }

        metidasLisas = 0;
        metidasRayadas = 0;
    }

    public void meterBola(BolaBillar bola) {
        if (bola.getNumero() != 0){
            bolasMesa.remove(bola);
            bolasCajetin.add(bola);
            if (bola.getNumero() != 8) {
                // Llevando la cuenta de las bolas metidas nos ahorramos hacer calculos para comprobar el ganador
                if(bola.getTipo() == TipoBola.LISA)
                    metidasLisas++;
                else
                    metidasRayadas++;
            }
        }
    }

    public ArrayList<BolaBillar> bolasMesa() {
        return (ArrayList<BolaBillar>)bolasMesa.clone();
    }

    public ArrayList<BolaBillar> bolasCajetin() {
        return (ArrayList<BolaBillar>)bolasCajetin.clone();
    }

    public boolean esPartidaIniciada() {
        return partidaIniciada;
    }

    public String obtenerGanador() {
        if(metidasLisas > metidasRayadas)
            return "Lisas";
        if(metidasLisas < metidasRayadas)
            return "Rayadas";

        return "Empate";
    }
}