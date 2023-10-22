package baseball.utils;

public class StringUtil {

    public static int[] stringToIntArray(String str) {
        int[] digits = new int[str.length()];
        for (int i = 0; i < str.length(); i++) digits[i] = str.charAt(i) - '0';

        return digits;
    }
}
