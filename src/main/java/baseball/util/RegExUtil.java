package baseball.util;

public class RegExUtil {

    public static String createRangeRegex(int startRange, int endRange) {
        StringBuilder regEx = new StringBuilder();

        regEx.append("^[");
        regEx.append(startRange);
        regEx.append("-");
        regEx.append(endRange);
        regEx.append("]+$");

        return regEx.toString();
    }
}
