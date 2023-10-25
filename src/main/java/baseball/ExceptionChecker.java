package baseball;

import java.util.ArrayList;
import java.util.List;

public class ExceptionChecker {

    private static final String REGAME = "1";
    private static final String QUIT = "2";
    private static final int ANSWER_SIZE = 3;
    private static final int ANSWER_MIN_NUM = 1;
    private static final int ANSWER_MAX_NUM = 9;
    private static final int END_NUMBER_SIZE = 1;

    public void checkAnswerInputException(String userInput) {
        checkAnswerSize(userInput);
        checkAnswerOnlyNumber(userInput);
        checkDuplicated(userInput);
        checkAnswerNumberRange(userInput);
    }

    public void checkRegameOrQuitInputException(String userInput) {
        checkEndNumberSize(userInput);
        checkEndOnlyNumber(userInput);
    }

    private void checkAnswerSize(String userInput) {
        if (userInput.length()!= ANSWER_SIZE) {
            throw new IllegalArgumentException("3자리 숫자만 입력 가능합니다.");
        }
    }

    private void checkAnswerOnlyNumber(String userInput) {
        for (int i = 0; i < ANSWER_SIZE; i++) {
            char num = userInput.charAt(i);
            if (!Character.isDigit(num)) {
                throw new IllegalArgumentException("숫자만 입력 가능합니다.");
            }
        }
    }

    private void checkAnswerNumberRange(String userInput) {
        for (int i = 0; i < ANSWER_SIZE; i++) {
            int num = Character.getNumericValue(userInput.charAt(i));
            if (!(num >= ANSWER_MIN_NUM && num <= ANSWER_MAX_NUM)) {
                throw new IllegalArgumentException("1~9사이 숫자만 입력 가능합니다.");
            }
        }
    }

    private void checkDuplicated(String userInput) {
        List<String> userInputToArr = new ArrayList<>();
        for (int i = 0; i < ANSWER_SIZE; i++) {
            String num = userInput.substring(i,i+1);
            if(userInputToArr.contains(num)) {
                throw new IllegalArgumentException("중복된 숫자는 입력이 불가능합니다.");
            }
            userInputToArr.add(num);
        }
    }

    private void checkEndNumberSize(String userInput) {
        if (userInput.length()!= END_NUMBER_SIZE) {
            throw new IllegalArgumentException("1자리 숫자만 입력 가능합니다.");
        }
    }

    private void checkEndOnlyNumber(String userInput) {
        if (!(userInput.equals(REGAME) || userInput.equals(QUIT))) {
            throw new IllegalArgumentException("1 혹은 2만 입력 가능합니다.");
        }
    }
}
