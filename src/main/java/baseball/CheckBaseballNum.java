package baseball;

public class CheckBaseballNum {
    static void isError(String baseballNum) throws IllegalArgumentException {
        if (Util.isNull(baseballNum)) {
            throw new IllegalArgumentException("BaseballNum 입력값 오류 : null이 입력되었습니다.");
        }
        if (!Util.isCorrectLength(baseballNum, 3)) {
            throw new IllegalArgumentException("BaseballNum 입력값 오류 : 올바른 길이(3)가 아닙니다");
        }
        if (!isCorrectRange(baseballNum)) {
            throw new IllegalArgumentException("BaseballNum 입력값 오류 : 1 ~ 9 범위 바깥의 수가 입력되었습니다");
        }
        if (isDuplicated(baseballNum)) {
            throw new IllegalArgumentException("BaseballNum 입력값 오류 : 같은 값이 입력되었습니다");
        }
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
