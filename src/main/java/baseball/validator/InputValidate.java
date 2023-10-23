package baseball.validator;

import static baseball.enums.Constant.BEGIN_NUMBER;
import static baseball.enums.Constant.END_NUMBER;
import static baseball.enums.Constant.GAME_COMMAND_LENGTH;
import static baseball.enums.Constant.GAME_END_COMMAND;
import static baseball.enums.Constant.GAME_RESTART_COMMAND;
import static baseball.enums.Constant.MAX_NUMBER_LENGTH;

import java.util.HashSet;
import java.util.Set;

public class InputValidate {

    private static final String NON_NUMERIC_ERROR_MESSAGE = "숫자만 입력해주세요";
    private static final String LENGTH_ERROR_MESSAGE = "입력 길이가 일치하지 않습니다 입력 길이는 : ";
    private static final String DUPLICATE_ERROR_MESSAGE = "중복된 숫자가 포함되어 있습니다";
    private static final String GAME_COMMAND_ERROR_MESSAGE = "올바른 명령이 아닙니다";

    public void validateNumeric(String input) {
        String stringValue = String.valueOf(input);
        for (char c : stringValue.toCharArray()) {
            int numericValue = Character.getNumericValue(c);
            if (numericValue < BEGIN_NUMBER.getConstant() || numericValue > END_NUMBER.getConstant()) {
                throw new IllegalArgumentException(NON_NUMERIC_ERROR_MESSAGE);
            }
        }
    }

    public void validateLength(String input) {
        int inputLength = input.length();
        if (inputLength != MAX_NUMBER_LENGTH.getConstant()) {
            throw new IllegalArgumentException(LENGTH_ERROR_MESSAGE + MAX_NUMBER_LENGTH.getConstant());
        }
    }

    public void validateDuplicateNumber(String input) {
        String stringValue = String.valueOf(input);
        Set<Character> characterSet = new HashSet<>();
        for (char c : stringValue.toCharArray()) {
            characterSet.add(c);
        }
        if (characterSet.size() != MAX_NUMBER_LENGTH.getConstant()) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
        }
    }

    public void validateGameCommand(String input) {
        String stringValue = String.valueOf(input);
        int inputLength = input.length();
        if (inputLength != GAME_COMMAND_LENGTH.getConstant()) {
            throw new IllegalArgumentException(GAME_COMMAND_ERROR_MESSAGE);
        }

        int numericValue = Character.getNumericValue(stringValue.charAt(0));
        if (!(numericValue == GAME_RESTART_COMMAND.getConstant() || numericValue == GAME_END_COMMAND.getConstant())) {
            throw new IllegalArgumentException(GAME_COMMAND_ERROR_MESSAGE);
        }
    }

}
