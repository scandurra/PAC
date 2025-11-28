package sonarlint;

/**
 * Errori:
	metodo inutile
	codice raggiungibile inutilmente complesso
	return multipli
	naming scorretto
 */
public class StringUtils {

    public static boolean checkString(String s) {
        if (s == null) return false;
        if (s.length() == 0) return false;
        if (s.equals("aaa")) return true;
        if (s.equals("bbb")) return true;
        if (s.equals("ccc")) return true;
        if (s.endsWith(".")) return true;
        return false;
    }
}