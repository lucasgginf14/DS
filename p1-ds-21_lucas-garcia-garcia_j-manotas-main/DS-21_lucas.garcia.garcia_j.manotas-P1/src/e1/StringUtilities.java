package e1;

public class StringUtilities {

    private static boolean isValidChar(char c, String params) {
        return Character.isDigit(c) || params.indexOf(c) >= 0;
    }

    public static boolean isValidString(String str, String params, int min) {
        if(str == null || str.isEmpty())
            return false;

        if(str.length() < min)
            return false;

        for (int i = 0; i < str.length(); i++)
            if (!isValidChar(str.charAt(i), params))
                return false;
        return true;
    }

    public static String lowercaseFirst(String str) {
        StringBuilder lower = new StringBuilder();
        StringBuilder upper = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if(Character.isUpperCase(c))
                upper.append(c);
            else if(Character.isLowerCase(c))
                lower.append(c);
        }

        return lower.toString() + upper.toString();
    }

    private static float longitudMediaPalabras(String[] palabras) {
        int suma = 0;
        for(int i = 0; i < palabras.length; i++)
            suma += palabras[i].length();

        return (float) suma / palabras.length;
    }

    private static int palabraMasLarga(String[] palabras) {
        int resultado = 0;

        for(int i = 0; i < palabras.length; i++)
            if(palabras[i].length()> resultado)
                resultado = palabras[i].length();

        return resultado;
    }

    public static boolean checkTextStats(String str, int min, int max) {
        if(str == null || str.isEmpty() || min <= 0 || max <= 0)
            throw new IllegalArgumentException();

        String[] palabras = str.split(" ");

        float media = longitudMediaPalabras(palabras);
        if(media < min || media > max)
            return false;

        return palabraMasLarga(palabras) <= 2 * media;
    }
}
