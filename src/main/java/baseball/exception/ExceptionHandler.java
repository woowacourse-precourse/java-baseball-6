package baseball.exception;

import baseball.game.AnswerLength;
import java.util.HashSet;
import java.util.Set;

public class ExceptionHandler {

    public String exceptionHandler(String userInput) {
        userElseInputException(userInput);
        userWrongLengthInputException(userInput);
        userDuplicatedInputException(userInput);
        userZeroInputException(userInput);

        return userInput;
    }

    private void userElseInputException(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (Exception exception) {
            throw new IllegalArgumentException("숫자 외 입력 예외");
        }
    }

    private void userWrongLengthInputException(String userInput) {
        if (userInput.length() != AnswerLength.ANSWER_LENGTH.getAnswerLength()) {
            throw new IllegalArgumentException("입력 길이 예외");
        }
    }

    private void userDuplicatedInputException(String userInput) {
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < AnswerLength.ANSWER_LENGTH.getAnswerLength(); i++) {
            set.add(userInput.charAt(i));
        }

        if (set.size() != AnswerLength.ANSWER_LENGTH.getAnswerLength()) {
            throw new IllegalArgumentException("중복된 입력 예외");
        }
    }

    private void userZeroInputException(String userInput) {
        for (int i = 0; i < AnswerLength.ANSWER_LENGTH.getAnswerLength(); i++) {
            if (Integer.parseInt(String.valueOf(userInput.charAt(i))) == 0) {
                throw new IllegalArgumentException("`0` 입력 예외");
            }
        }
    }

    public String userElseInputAfterEndPhraseException(String userInput) {

        if (userInput.equals("1") || userInput.equals("2")) {
            return userInput;
        }

        throw new IllegalArgumentException("1, 2 이외 입력 예외");
    }
}
