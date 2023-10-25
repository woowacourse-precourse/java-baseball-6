package baseball;

public class CheckBaseballNum {
    static boolean isError(String baseballNum) {
        if (isNull(baseballNum)) {
            return (true);
        }
        return (!isCorrectLength(baseballNum) ||
                isDuplicated(baseballNum) ||
                !isCorrectRange(baseballNum));
    }

    static boolean isNull(String baseballNum) {
        return (baseballNum == null);
    }

    static boolean isCorrectLength(String baseballNum) {
        return (baseballNum.length() == 3);
    }

    static boolean isCorrectRange(String baseballNum) {
        for (int i = 0; i < 3; i++) {
            if (!isDigit(baseballNum.charAt(i))) {
                return (false);
            }
        }
        return (true);
    }

    static boolean isDuplicated(String baseballNum) {
        return (baseballNum.charAt(0) == baseballNum.charAt(1) ||
                baseballNum.charAt(0) == baseballNum.charAt(2) ||
                baseballNum.charAt(1) == baseballNum.charAt(2));
    }

    static boolean isDigit(char num) {
        return (num >= '1' && num <= '9');
    }
}
