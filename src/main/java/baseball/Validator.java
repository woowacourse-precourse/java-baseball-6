package baseball;

import static baseball.Constants.GAME_COMMAND_LENGTH;
import static baseball.Constants.NUMBER_LENGTH;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Validator {

    public static void validatePlayerNumber(String playerNumber) {
        if (isBlank(playerNumber)) {
            throw new IllegalArgumentException(ExceptionMessage.BLANK.getMessage());
        }
        if (isNotNumeric(playerNumber)) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_NUMERIC.getMessage());
        }
        if (isNotLength(playerNumber, NUMBER_LENGTH)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMBER_LENGTH.getMessage());
        }
        if (isDuplicate(playerNumber)) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_NUMBER.getMessage());
        }
    }

    public static void validateGameCommand(String gameCommand) {
        if (isBlank(gameCommand)) {
            throw new IllegalArgumentException(ExceptionMessage.BLANK.getMessage());
        }
        if (isNotNumeric(gameCommand)) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_NUMERIC.getMessage());
        }
        if (isNotLength(gameCommand, GAME_COMMAND_LENGTH)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_GAME_COMMAND_LENGTH.getMessage());
        }
    }

    private static boolean isBlank(String number) {
        return null == number || number.isBlank();
    }

    private static boolean isNotNumeric(String number) {
        try {
            Integer.parseInt(number);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private static boolean isNotLength(String number, int length) {
        return number.length() != length;
    }

    private static boolean isDuplicate(String number) {
        Set<String> set = new HashSet<>(Arrays.asList(number.split("")));
        return set.size() != NUMBER_LENGTH;
    }

}
