package baseball;

public class ExceptionControl {
    public static void checkUserNumberInput(String userNumber) {
        if (userNumber.length() != 3 ||
                userNumber.charAt(0) == userNumber.charAt(1) ||
                userNumber.charAt(1) == userNumber.charAt(2) ||
                userNumber.charAt(2) == userNumber.charAt(0)) {
            throw new IllegalArgumentException("잘못된 입력입니다. 0을 제외한 3가지의 수를 입력하세요");
        }
    }

    public static void checkRestartGameInput(int restartCount) {
        if (restartCount != 1 && restartCount != 2) {
            throw new IllegalArgumentException("잘못된 입력입니다. 1 또는 2만 입력하세요");
        }
    }
}
