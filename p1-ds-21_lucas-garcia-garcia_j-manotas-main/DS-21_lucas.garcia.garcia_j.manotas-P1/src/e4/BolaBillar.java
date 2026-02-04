package e4;

public enum BolaBillar {
    BLANCA(0, "BLANCO", TipoBola.LISA),
    BOLA1(1, "AMARILLO", TipoBola.LISA),
    BOLA2(2, "AZUL", TipoBola.LISA),
    BOLA3(3, "ROJO", TipoBola.LISA),
    BOLA4(4, "VIOLETA", TipoBola.LISA),
    BOLA5(5, "NARANJA", TipoBola.LISA),
    BOLA6(6, "VERDE", TipoBola.LISA),
    BOLA7(7, "GRANATE", TipoBola.LISA),
    BOLA8(8, "NEGRO", TipoBola.LISA),
    BOLA9(9,"AMARILLO", TipoBola.RAYADA),
    BOLA10(10, "AZUL", TipoBola.RAYADA),
    BOLA11(11, "ROJO", TipoBola.RAYADA),
    BOLA12(12, "VIOLETA", TipoBola.RAYADA),
    BOLA13(13, "NARANJA", TipoBola.RAYADA),
    BOLA14(14, "VERDE", TipoBola.RAYADA),
    BOLA15(15, "GRANATE", TipoBola.RAYADA);

    private final int numero;
    public int getNumero() {
        return numero;
    }

    private final String color;
    public String getColor(){
        return color;
    }

    private final TipoBola tipo;
    public TipoBola getTipo(){
        return tipo;
    }

    BolaBillar(int numero, String color, TipoBola tipo) {
        this.numero = numero;
        this.color = color;
        this.tipo = tipo;
    }
}