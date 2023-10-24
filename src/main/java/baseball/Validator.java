package baseball;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    public static void validatePlayerNum(List<Integer> player) {
        validateDuplicateNum(player);
        validateDigitsOfNum(player);
        validateRangeOfNum(player);
    }

    public static void validateDuplicateNum(List<Integer> player) {
        Set<Integer> numSet = new HashSet<>(player);

        if(numSet.size() != player.size()) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateDigitsOfNum(List<Integer> player) {
        if(player.size() != 3) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateRangeOfNum(List<Integer> player) {
        for(int s : player) {
            if(s > 9 || s < 1) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void validateRestartNum(int num) {
        if(num != 1 && num != 2) {
            throw new IllegalArgumentException();
        }
    }
}
