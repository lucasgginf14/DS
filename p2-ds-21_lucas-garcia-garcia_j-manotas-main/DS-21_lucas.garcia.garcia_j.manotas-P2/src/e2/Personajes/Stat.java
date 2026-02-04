package e2.Personajes;

public class Stat {

    private final int minValue;
    private final int maxValue;
    private int value;
    public int getValue() {
        return value;
    }

    public Stat(int minValue, int maxValue){
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public void setValue(int value) {
        if(value < minValue || value > maxValue)
            throw new IllegalArgumentException("El valor de la estadistica no pertenece a un intervalo valido");

        this.value = value;
    }
}