package baseball;

import java.util.HashSet;
import java.util.Set;

public class InputValidator {

    // TODO: 사용자가 입력한 정답을 클래스로 바꾼뒤 리팩토링 필요
    public static void validateInputAnswer(String inputAnswer) {
        if (inputAnswer.length() != Computer.NUMBER_DIGIT) {
            throw new IllegalArgumentException();
        }

        Set<Character> tempSet = new HashSet<>();

        for (Character ch : inputAnswer.toCharArray()) {
            if (!Character.isDigit(ch) || !tempSet.add(ch)) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void validateRetryInput(String retryInput) {
        if (!retryInput.equals(GameController.RETRY_COMMAND) && !retryInput.equals(
            GameController.END_COMMAND)) {
            throw new IllegalArgumentException();
        }
    }
}
