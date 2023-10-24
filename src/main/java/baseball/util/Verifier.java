package baseball.util;

/**
 * 숫자 야구 게임의 입력값을 검증하는 클래스
 */
public class Verifier {
    /**
     * 입력값 검증
     * @see baseball.view.InputView getUserInput()
     * @param userInput getUserInput()에서 입력받은 값
     * @throws IllegalArgumentException
     *          1부터 9까지 서로 다른 수로 이루어진 3자리의 수가 아닐 경우
     */
    public static void verifyUserInput(String userInput) {
        if (!userInput.matches("^(?!.*(.).*\\1)[1-9]{3}$")) {
            throw new IllegalArgumentException("1부터 9까지 서로 다른 3자리 수를 입력해주세요.");
        }
    }

    /**
     * 재시작 입력값 검증
     * @param restartInput getRestartInput()에서 입력받은 값
     * @see baseball.view.InputView getRestartInput()
     * @throws IllegalArgumentException
     *          입력값이 1 또는 2가 아닐 경우
     */
    public static void verifyRestartInput(String restartInput) {
        if (!restartInput.matches("[1-2]")) {
            throw new IllegalArgumentException("입력값은 1 또는 2여야 합니다.");
        }
    }
}
