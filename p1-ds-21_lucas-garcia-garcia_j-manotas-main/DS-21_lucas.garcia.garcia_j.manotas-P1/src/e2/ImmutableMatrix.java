package e2;

public class ImmutableMatrix {

    private final int[][] contenidoMatriz;

    public ImmutableMatrix(int[][] matriz) {
        contenidoMatriz = new int[matriz.length][matriz[0].length];

        int col = matriz[0].length;
        for (int i = 0; i < matriz.length; i++)
        {
            if (matriz[i].length != col)
                throw new IllegalArgumentException();
            System.arraycopy(matriz[i], 0, contenidoMatriz[i], 0, matriz[i].length);
        }
    }

    public ImmutableMatrix(int filas, int columnas) {
        contenidoMatriz= new int [filas][columnas];

        for(int i = 0; i < filas; i++)
            for(int j = 0; j < columnas; j++)
                contenidoMatriz[i][j] = 1 + j + i * columnas;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int[] ints : contenidoMatriz) {
            sb.append('[');
            for (int j = 0; j < contenidoMatriz[0].length; j++) {
                sb.append(ints[j]);
                sb.append(j < contenidoMatriz[0].length - 1 ? ", " : "]\n");
            }
        }

        return sb.toString();
    }

    public int at(int row, int col) {
        if(row < 0 || row >= contenidoMatriz.length || col < 0 || col >= contenidoMatriz[row].length)
            throw new IllegalArgumentException();

        return contenidoMatriz[row][col];
    }

    public int rowCount() {
        return contenidoMatriz.length;
    }

    public int columnCount() {
        return contenidoMatriz[0].length;
    }

    public int[][] toArray2D() {
        return contenidoMatriz;
    }

    public ImmutableMatrix reverse() {
        ImmutableMatrix reverse = new ImmutableMatrix(contenidoMatriz);

        for(int i = 0; i < contenidoMatriz.length; i++)
            for(int j = 0; j <contenidoMatriz[i].length/2; j++) {
                int[][] m = reverse.contenidoMatriz;
                int temp = m[i][j];

                m[i][j] = m[i][m[i].length - j - 1];
                m[i][m[i].length - j - 1] = temp;
            }

        return reverse;
    }

    public ImmutableMatrix transpose() {
        ImmutableMatrix traspuesta = new ImmutableMatrix(columnCount(),rowCount());

        for(int i = 0; i < columnCount(); i++)
            for(int j = 0; j < rowCount(); j++)
                traspuesta.contenidoMatriz[i][j]= contenidoMatriz[j][i];

        return traspuesta;
    }

    public ImmutableMatrix reshape(int columnas) {
        if((rowCount() * columnCount()) % columnas != 0)
            throw new IllegalArgumentException();

        ImmutableMatrix resultado = new ImmutableMatrix(rowCount() * columnCount() / columnas, columnas);

        for (int i = 0; i < resultado.contenidoMatriz.length; i++)
            for (int j = 0; j < columnas; j++){
                int indice = j + i * columnas;
                resultado.contenidoMatriz[i][j] = contenidoMatriz[indice / columnCount()][indice % columnCount()];
            }

        return resultado;
    }
}