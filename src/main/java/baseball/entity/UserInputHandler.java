package baseball.entity;

public class UserInputHandler {
    // 게임중, 사용자 입력 예외 처리를 위한 함수
    public static void validInputNumber(String inputNumber) {
        // 사용자 입력의 길이가 3이 아니면 예외 처리
        if (inputNumber.length() != 3) {
            throw new IllegalArgumentException();
        }

        // 사용자의 입력이 1~9까지 숫자가 아니라면 예외 처리
        for (int i = 0; i < 3; i++) {
            char currentNumber = inputNumber.charAt(i);
            if (currentNumber < '1' || currentNumber > '9') {
                throw new IllegalArgumentException();
            }
        }

        // 사용자의 입력이 서로 다른 숫자가 아니라면 예외 처리
        if (inputNumber.charAt(0) == inputNumber.charAt(1)) {
            throw new IllegalArgumentException();
        }
        if (inputNumber.charAt(0) == inputNumber.charAt(2)) {
            throw new IllegalArgumentException();
        }
        if (inputNumber.charAt(1) == inputNumber.charAt(2)) {
            throw new IllegalArgumentException();
        }

    }

    // 게임종료 후, 사용자 입력 예외 처리를 위한 함수
    public static void validRestartNumber(String restartNumber) {
        // 사용자 입력이 1 또는 2가 아니면 예외 처리
        if (!restartNumber.equals("1") && !restartNumber.equals("2")) {
            throw new IllegalArgumentException();
        }
    }
}
