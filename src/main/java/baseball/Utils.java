package baseball;

public class Utils {
    public static int stringToInt(String str, int i) {
        char strToChar = str.charAt(i);
        return Character.getNumericValue(strToChar);
    }

}
