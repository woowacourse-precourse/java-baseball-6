package baseball;

import java.util.HashSet;
import java.util.Set;

public class Validator {
    public static boolean validPlayerNumbers(String playerNumbers) {
        if (isValidLengthAndRangeNumber(playerNumbers) && isNotDuplicate(playerNumbers))
            return true;
        throw new IllegalArgumentException();
    }

    public static boolean validPlayerContinue(String playerContinue) {
        if ("1".equals(playerContinue) || "2".equals(playerContinue))
            return true;
        throw new IllegalArgumentException();
    }

    private static boolean isValidLengthAndRangeNumber(String str) {
        return str.matches("^[1-9]{3}$");
    }

    private static boolean isNotDuplicate(String str) {
        Set<Character> set = new HashSet<>();
        for (char num : str.toCharArray()) {
            set.add(num);
        }
        return str.length() == set.size();
    }

}
