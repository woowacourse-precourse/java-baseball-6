package baseball.error;

import java.util.*;

public class GameInputErrorException implements ErrorException{
    @Override
    public void checkUserInputValidate(String message) {
        throw new IllegalArgumentException(message);
    }

    private static boolean isNumeric(String checkNumber) {
        return checkNumber.matches("-?\\d+(\\.\\d+)?");
    }

    private static boolean isNumberRange(String checkNumber) {
        return checkNumber.length() == 3;
    }

    private static boolean hasDuplicateNumber(String checkNumber) {
        Set<Character> checkNumberToSet = new HashSet<>(changeStringToCharList(checkNumber));
        return checkNumber.length() == checkNumberToSet.size();
    }

    private static List<Character> changeStringToCharList(String checkString) {
        List<Character> result = new ArrayList<>();
        for (char c : checkString.toCharArray()) {
            result.add(c);
        }
        return result;
    }
}
