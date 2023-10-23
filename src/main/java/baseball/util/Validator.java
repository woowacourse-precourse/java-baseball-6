package baseball.util;

import baseball.config.Config;
import baseball.domain.Command;
import java.util.ArrayList;
import java.util.List;

public class Validator {
    public static boolean isInvalid(List<Integer> userNumbers) {
        return isNotNumber(userNumbers) || isNotValidDigits(userNumbers) || hasDuplicatedNumbers(userNumbers);
    }

    public static boolean isInvalid(String input) {
        return !Command.isExit(input) && !Command.isRestart(input);
    }

    private static boolean isNotValidDigits(List<Integer> userNumbers) {
        return Config.isNotMaxNumbers(userNumbers.size());
    }

    private static boolean isNotNumber(List<Integer> userNumbers) {
        for (int number : userNumbers) {
            if (Config.isInvalidRange(number)) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasDuplicatedNumbers(List<Integer> userNumbers) {
        List<Integer> temp = new ArrayList<>();
        for (int number : userNumbers) {
            if (temp.contains(number)) {
                return true;
            }
            temp.add(number);
        }
        return false;
    }

}
