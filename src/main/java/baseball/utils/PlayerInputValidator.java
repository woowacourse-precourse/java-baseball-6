package baseball.utils;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class PlayerInputValidator {

    private static final int MAX_LENGTH = 3;
    private static final Pattern PLAYER_REGEX = Pattern.compile("[1-9]{3}");

    public static void validatePlayerNumber(String playerNumber) {
        validateNumbersLength(playerNumber);
        validateNumbersType(playerNumber);
        validateDuplicateNumbers(playerNumber);
    }


    private static void validateNumbersLength(String playerNumber) {
        if (playerNumber.length() != MAX_LENGTH) {
            throw new IllegalArgumentException(ExceptionMessage.NUMBERS_LENGTH_ERROR.getMessage());
        }
    }

    private static void validateDuplicateNumbers(String playerNumber) {
        Set<Character> numberSet = new HashSet<>();

        for (char c : playerNumber.toCharArray()) {

            if (numberSet.contains(c)) {
                throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_NUMBER_ERROR.getMessage());
            }
            numberSet.add(c);
        }

    }

    private static void validateNumbersType(String playerNumber) {
        if (!PLAYER_REGEX.matcher(playerNumber).matches()) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_NUMBER_ERROR.getMessage());
        }
    }
}
