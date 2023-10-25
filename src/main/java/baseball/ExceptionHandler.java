package baseball;

public class ExceptionHandler {

    /**
     * 사용자가 입력한 숫자 유효성 체크 함수
     */
    public void validateUserInput(String userInput) {
        if (userInput.length() != 3) {
            throw new IllegalArgumentException("입력은 3자리여야 합니다.");
        }
        for (int i = 0; i < userInput.length(); i++) {
            if (userInput.charAt(i) < '1' || userInput.charAt(i) > '9') {
                throw new IllegalArgumentException("입력은 1~9 숫자로만 구성되어야 합니다.");
            }
        }
    }

    /**
     * 사용자가 입력한 재시작 옵션 유효성 체크 함수
     */
    public void validateRestartOption(String restartOption) {
        if (!restartOption.equals("1") && !restartOption.equals("2")) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

}
