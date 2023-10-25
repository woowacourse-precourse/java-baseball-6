package baseball.validator;

import static baseball.enums.Constant.BEGIN_NUMBER;
import static baseball.enums.Constant.END_NUMBER;
import static baseball.enums.Constant.GAME_COMMAND_LENGTH;
import static baseball.enums.Constant.GAME_END_COMMAND;
import static baseball.enums.Constant.GAME_RESTART_COMMAND;
import static baseball.enums.Constant.MAX_NUMBER_LENGTH;

import baseball.enums.Message;
import java.util.HashSet;
import java.util.Set;

public class InputValidate {

    public void validateNumeric(String input) {
        String stringValue = String.valueOf(input);
        for (char c : stringValue.toCharArray()) {
            int numericValue = Character.getNumericValue(c);
            if (numericValue < BEGIN_NUMBER.getConstant() || numericValue > END_NUMBER.getConstant()) {
                throw new IllegalArgumentException(Message.NON_NUMERIC_ERROR_MESSAGE.getMessage());
            }
        }
    }

    public void validateLength(String input) {
        int inputLength = input.length();
        if (inputLength != MAX_NUMBER_LENGTH.getConstant()) {
            throw new IllegalArgumentException(
                    Message.LENGTH_ERROR_MESSAGE.getMessage() + MAX_NUMBER_LENGTH.getConstant());
        }
    }

    public void validateDuplicateNumber(String input) {
        String stringValue = String.valueOf(input);
        Set<Character> characterSet = new HashSet<>();
        for (char c : stringValue.toCharArray()) {
            characterSet.add(c);
        }
        if (characterSet.size() != MAX_NUMBER_LENGTH.getConstant()) {
            throw new IllegalArgumentException(Message.DUPLICATE_ERROR_MESSAGE.getMessage());
        }
    }

    public void validateGameCommand(String input) {
        String stringValue = String.valueOf(input);
        int inputLength = input.length();
        if (inputLength != GAME_COMMAND_LENGTH.getConstant()) {
            throw new IllegalArgumentException(Message.GAME_COMMAND_ERROR_MESSAGE.getMessage());
        }

        int numericValue = Character.getNumericValue(stringValue.charAt(0));
        if (!(numericValue == GAME_RESTART_COMMAND.getConstant() || numericValue == GAME_END_COMMAND.getConstant())) {
            throw new IllegalArgumentException(Message.GAME_COMMAND_ERROR_MESSAGE.getMessage());
        }
    }

}
