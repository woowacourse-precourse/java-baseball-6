package baseball.global.util;

public class NumberUtil {
    
    public static Integer parseIntOrThrowException(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
