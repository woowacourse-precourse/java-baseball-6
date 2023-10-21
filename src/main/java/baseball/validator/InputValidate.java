package baseball.validator;

import java.util.HashSet;
import java.util.Set;

public class InputValidate {

    private static final int BEGIN_ASCII_CODE = 48; // 숫자 0
    private static final int END_ASCII_CODE = 57; // 숫자 9
    private static final int MAX_NUMBER_LENGTH = 3;
    private static final int GAME_RESTART_COMMAND = 49;
    private static final int GAME_END_COMMAND = 50;
    private static final int GAME_COMMAND_LENGTH = 1;
    private static final String NON_NUMERIC_ERROR_MESSAGE = "숫자만 입력해주세요";
    private static final String LENGTH_ERROR_MESSAGE = "입력 길이가 일치하지 않습니다 입력 길이는 : ";
    private static final String DUPLICATE_ERROR_MESSAGE = "중복된 숫자가 포함되어 있습니다";
    private static final String GAME_COMMAND_ERROR_MESSAGE = "올바른 명령이 아닙니다";

    public void validateNumeric(String input) {
        String stringValue = String.valueOf(input);
        for (char c : stringValue.toCharArray()) {
            if (c < BEGIN_ASCII_CODE || c > END_ASCII_CODE) {
                throw new IllegalArgumentException(NON_NUMERIC_ERROR_MESSAGE);
            }
        }
    }

    public void validateLength(String input) {
        int inputLength = input.length();
        if (inputLength != MAX_NUMBER_LENGTH) {
            throw new IllegalArgumentException(LENGTH_ERROR_MESSAGE + MAX_NUMBER_LENGTH);
        }
    }

    public void validateDuplicateNumber(String input) {
        String stringValue = String.valueOf(input);
        Set<Character> characterSet = new HashSet<>();
        for (char c : stringValue.toCharArray()) {
            characterSet.add(c);
        }
        if (characterSet.size() != MAX_NUMBER_LENGTH) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
        }
    }

    public void validateGameCommand(String input) {
        String stringValue = String.valueOf(input);
        int inputLength = input.length();
        if (inputLength != GAME_COMMAND_LENGTH) {
            throw new IllegalArgumentException(GAME_COMMAND_ERROR_MESSAGE);
        }

        if (!(stringValue.charAt(0) == GAME_RESTART_COMMAND || stringValue.charAt(0) == GAME_END_COMMAND)) {
            throw new IllegalArgumentException(GAME_COMMAND_ERROR_MESSAGE);
        }
    }

}
