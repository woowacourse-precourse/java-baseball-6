package baseball.validator;

import baseball.resource.ErrorMessage;
import baseball.resource.GameValue;
import baseball.util.RegularExpression;

import java.util.HashSet;
import java.util.Set;

public class InputValidation {

    public static void isNull(String playerNumber) {
        if (playerNumber == null) {
            throw new IllegalArgumentException("입력값이 전달되지 않았습니다.");
        }
    }
    public static void isNumber(String playerNumber) {
        if (!playerNumber.matches(RegularExpression.NUMBER_REGEX)) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_ERROR_MESSAGE);
        }
    }

    public static void isThreeLetter(String playerNumber) {
        if (playerNumber.length() != GameValue.MAX_LENGTH) {
            throw new IllegalArgumentException(GameValue.MAX_LENGTH + ErrorMessage.LENGTH_ERROR_MESSAGE);
        }
    }

    public static void isNumberScope(String playerNumber) {
        for (int i = 0; i < playerNumber.length(); i++) {
            numberScopeCheck(Character.getNumericValue(playerNumber.charAt(i)));
        }
    }

    public static void numberScopeCheck(int number) {
        if ((number < GameValue.MIN_NUMBER)
                || (number > GameValue.MAX_NUMBER)) {
            throw new IllegalArgumentException(ErrorMessage.SCOPE_NUMBER_ERROR_MESSAGE);
        }
    }

    public static void isDuplicateNumber(String playerNumber) {
        Set<Integer> duplicateCheckSet = new HashSet<>();
        for (int i = 0; i < playerNumber.length(); i++) {
            duplicateCheckSet.add(Character.getNumericValue(playerNumber.charAt(i)));
        }
        if (duplicateCheckSet.size() != 3) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_ERROR_MESSAGE);
        }
    }

    public static void reStartNumberCheck(String reStartPlayerNumber) {
        if (!reStartPlayerNumber.equals("1") && !reStartPlayerNumber.equals("2")) {
            throw new IllegalArgumentException(ErrorMessage.RESTART_ERROR_MESSAGE);
        }
    }

    public static void reStartCheck(String reStartPlayerNumber) {
        isNull(reStartPlayerNumber);
        isNumber(reStartPlayerNumber);
        reStartNumberCheck(reStartPlayerNumber);
    }
}