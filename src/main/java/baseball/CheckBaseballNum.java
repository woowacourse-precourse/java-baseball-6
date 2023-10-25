package baseball;

public class CheckBaseballNum {
    static boolean isError(String baseballNum) {
        if (Util.isNull(baseballNum)) {
            return (true);
        }
        return (!Util.isCorrectLength(baseballNum, 3) ||
                isDuplicated(baseballNum) ||
                !isCorrectRange(baseballNum));
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
