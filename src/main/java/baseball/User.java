package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class User {

    private static final String USER_INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final int NUMBER_LENGTH = 3;
    private static final Pattern pattern = Pattern.compile("([1-9]{3,3})");
    private static final String INPUT_LENGTH_ERROR_MESSAGE = "3자리수를 입력해주세요.";
    private static final String INPUT_DIGIT_ERROR_MESSAGE = "숫자가 아닌 값이 입력되었습니다.";
    String userInputNumber;

    public void setUserInputNumber() {
        System.out.println(USER_INPUT_NUMBER_MESSAGE);
        String inputNumber = Console.readLine();
        validateInputNumber(inputNumber);
        this.userInputNumber = inputNumber;
    }

    public String getUserInputNumber() {
        return userInputNumber;
    }

    private static void validateInputNumber(String inputNumber) {
        validateLength(inputNumber);
        validatePattern(inputNumber);
    }

    private static void validatePattern(String inputNumber) {
        if (!pattern.matcher(inputNumber).matches()) {
            throw new IllegalArgumentException(INPUT_DIGIT_ERROR_MESSAGE);
        }
    }

    private static void validateLength(String inputNumber) {
        if (inputNumber.length() != NUMBER_LENGTH) {
            throw new IllegalArgumentException(INPUT_LENGTH_ERROR_MESSAGE);
        }
    }

    // test method
    public void setUserInputNumber(String inputNumber) {
        System.out.println(USER_INPUT_NUMBER_MESSAGE);
        this.userInputNumber = inputNumber;
    }

}
