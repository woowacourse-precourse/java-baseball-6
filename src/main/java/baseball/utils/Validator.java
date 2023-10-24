package baseball.utils;

import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    private static final String ERROR_PREFIX = "[ERROR] : ";
    private static final String INPUT_NUMBER_IS_NOT_INTEGER_TYPE_EXCEPTION = "정수 타입이 아닙니다";
    private static final String INPUT_NUMBER_LENGTH_EXCEPTION = "길이가 일치하지 않습니다";
    private static final String INPUT_NUMBER_IS_DUPLICATE_EXCEPTION = "중복된 숫자가 존재합니다";
    private static final String INPUT_RESTART_BUTTON_NUMBER_RANGE_EXCEPTION = "재시작 버튼 입력은 1 또는 2만 가능합니다";
    private static final String INPUT_NUMBER_SPLIT_TO_DIGIT_REGEX = "";
    private static final String INPUT_NUMBER_TYPE_IS_INTEGER_REGEX = "^[-+]?\\d+$";
    private static final String GAME_RESTART_VALUE = "1";
    private static final String GAME_END_VALUE = "2";
    private static final int INPUT_NUMBER_CORRECT_LENGTH = 3;

    public void validateInputNumber(String inputNumber) {
        if (isNotIntegerType(inputNumber)) {
            throw new IllegalArgumentException(ERROR_PREFIX + INPUT_NUMBER_IS_NOT_INTEGER_TYPE_EXCEPTION);
        }
        if (isNotCorrectLength(inputNumber)) {
            throw new IllegalArgumentException(ERROR_PREFIX + INPUT_NUMBER_LENGTH_EXCEPTION);
        }
        if (isDuplicateNumber(inputNumber)) {
            throw new IllegalArgumentException(ERROR_PREFIX + INPUT_NUMBER_IS_DUPLICATE_EXCEPTION);
        }
    }

    public void validatePlayButton(String playButton) {
        if (isNotIntegerType(playButton)) {
            throw new IllegalArgumentException(ERROR_PREFIX + INPUT_NUMBER_IS_NOT_INTEGER_TYPE_EXCEPTION);
        }
        if (isNotCorrectButton(playButton)) {
            throw new IllegalArgumentException(ERROR_PREFIX + INPUT_RESTART_BUTTON_NUMBER_RANGE_EXCEPTION);
        }
    }

    public boolean isDuplicateNumber(String inputNumber) {
        HashSet<String> numberSet = new HashSet<>();
        String[] eachInputNumber = inputNumber.split(INPUT_NUMBER_SPLIT_TO_DIGIT_REGEX);

        for (String number : eachInputNumber) {
            if (numberSet.contains(number)) {
                return true;
            }
            numberSet.add(number);
        }
        return false;
    }

    public boolean isNotCorrectLength(String inputNumber) {
        return inputNumber.length() != INPUT_NUMBER_CORRECT_LENGTH;
    }

    public boolean isNotIntegerType(String inputNumber) {
        Pattern pattern = Pattern.compile(INPUT_NUMBER_TYPE_IS_INTEGER_REGEX);
        Matcher matcher = pattern.matcher(inputNumber);
        return !matcher.matches();
    }

    public boolean isNotCorrectButton(String playButton) {
        return !(playButton.equals(GAME_RESTART_VALUE) || playButton.equals(GAME_END_VALUE));
    }
}
