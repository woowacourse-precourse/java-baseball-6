package baseball;

public class CheckRestartNum {
    static void isError(String restartString) throws IllegalArgumentException {
        if (Util.isNull(restartString)) {
            throw new IllegalArgumentException("RestartNum 입력값 오류 : null이 입력되었습니다");
        }
        if (!Util.isCorrectLength(restartString, 1)) {
            throw new IllegalArgumentException("RestartNum 입력값 오류 : 올바른 길이(1)가 아닙니다");
        }
        if (!isCorrectValue(restartString)) {
            throw new IllegalArgumentException("RestartNum 입력값 오류 : 1 ~ 2 범위 바깥의 수가 입력되었습니다");
        }
    }

    static boolean isCorrectValue(String restartString) {
        return (restartString.charAt(0) == '1' || restartString.charAt(0) == '2');
    }
}
