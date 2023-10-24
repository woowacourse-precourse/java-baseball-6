package baseball.util;

public class PatternHelper {
        public static String getDistinctDigitNumberPattern(int limit) {
                return "^(?!.*(.).*\\1)[1-9]{" + limit + "}$";
        }
}
