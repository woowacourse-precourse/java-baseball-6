package baseball.util;

import baseball.config.Config;
import baseball.domain.Command;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        return userNumbers.stream()
                .anyMatch(Config::isInvalidRange);
    }

    private static boolean hasDuplicatedNumbers(List<Integer> userNumbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();

        return userNumbers.stream()
                .anyMatch(number -> !uniqueNumbers.add(number));
    }

}
