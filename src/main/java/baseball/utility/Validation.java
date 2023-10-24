package baseball.utility;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Validation {
    private static final int GAME_RULE_NUMBER_LENGTH = 3;
    private static final char GAME_RULE_NUMBER_CHAR_MIN = '1';
    private static final char GAME_RULE_NUMBER_CHAR_MAX = '9';
    private static final String ERROR_MESSAGE_LENGTH = "조합된 수는 반드시 세 자리 입니다.";
    private static final String ERROR_MESSAGE_RANGE = "1부터 9까지의 숫자로만 조합할 수 있습니다.";
    private static final String ERROR_MESSAGE_DUPLICATE = "세 자리의 숫자는 서로 중복될 수 없습니다.";

    public List<Integer> checkValidationNumber(String inputNumber) {
        if (!isTreeChar(inputNumber)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_LENGTH);
        } else if (!isCharInRange(inputNumber)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_RANGE);
        } else if (!isNotDouble(inputNumber)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_DUPLICATE);
        }

        return convertStrToIntList(inputNumber);
    }

    public boolean isTreeChar(String inputNumber) {
        return inputNumber.length() == GAME_RULE_NUMBER_LENGTH;
    }

    public boolean isCharInRange(String inputNumber) {
        for (int i = 0; i < inputNumber.length(); i++) {
            if (!isCheckInRange(inputNumber.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean isCheckInRange(char checkChar) {
        return checkChar >= GAME_RULE_NUMBER_CHAR_MIN && checkChar <= GAME_RULE_NUMBER_CHAR_MAX;
    }

    public boolean isNotDouble(String inputNumber) {
        String[] numbers = inputNumber.split("");
        Set<String> setNumbers = Arrays.stream(numbers).collect(Collectors.toSet());

        return setNumbers.size() == GAME_RULE_NUMBER_LENGTH;
    }

    public List<Integer> convertStrToIntList(String inputNumber) {
        int[] toIntList = Stream.of(inputNumber.split("")).mapToInt(Integer::parseInt).toArray();
        return Arrays.stream(toIntList).boxed().collect(Collectors.toList());
    }
}