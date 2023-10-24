package baseball.view;

import baseball.util.common.Common;
import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.regex.Pattern;

public class UserInputView {
    private static final String REGEXP_ONLY_NUM = "\\d+";
    private static final String VALID_LENGTH = "숫자의 길이가 " + Common.NUM_LENGTH + "와 다릅니다.";
    private static final String VALID_IS_NUM = "숫자가 아닌 문자가 입력 되었습니다.";
    private static final String VALID_IS_DUPLICATE = "중복된 값이 들어갔습니다.";

    private static final String VALID_IS_NULL = "빈 값이 들어갔습니다.";

    public UserInputView() {
    }

    public String inputUserNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        try {
            String stringDigitsFromUserInput = Console.readLine();

            isStringEmpty(stringDigitsFromUserInput);
            validateUserInputLength(stringDigitsFromUserInput);
            validateIsNumber(stringDigitsFromUserInput);
            validateHasDuplicateNumber(stringDigitsFromUserInput);

            return stringDigitsFromUserInput;
        } catch (NoSuchElementException | NullPointerException e) {
            throw new IllegalArgumentException(VALID_IS_NULL);
        }
    }

    public String isContinueGameByUserInput() {
        try {
            String isContinueByUserInput = Console.readLine();
            isStringEmpty(isContinueByUserInput);
            validateIsNumber(isContinueByUserInput);
            return isContinueByUserInput;
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException(VALID_IS_NULL);
        }
    }

    private void isStringEmpty(String userInput) {
        if (userInput == null || userInput.isBlank()) {
            throw new NullPointerException();
        }
    }

    private void validateUserInputLength(String stringDigitsFromUserInput) {
        if (stringDigitsFromUserInput.length() != Common.NUM_LENGTH) {
            throw new IllegalArgumentException(VALID_LENGTH);
        }
    }

    private void validateIsNumber(String stringDigitsFromUserInput) {
        if (!Pattern.matches(REGEXP_ONLY_NUM, stringDigitsFromUserInput)) {
            throw new IllegalArgumentException(VALID_IS_NUM);
        }
    }

    private void validateHasDuplicateNumber(String stringDigitsFromUserInput) {
        Set<Character> userInputCharBySet = new HashSet<>();
        for (char userInputChar : stringDigitsFromUserInput.toCharArray()) {
            userInputCharBySet.add(userInputChar);
        }
        if (userInputCharBySet.size() != stringDigitsFromUserInput.length()) {
            throw new IllegalArgumentException(VALID_IS_DUPLICATE);
        }
    }
}
