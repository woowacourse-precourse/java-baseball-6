package baseball;

import java.util.List;

public class Validator {
    public static class closeValidator {
        static void validateValue(int closeOpt) {
            if (closeOpt != 1 && closeOpt != 2) {
                throw new IllegalArgumentException();
            }
        }
    }
    public static class UserGuessValidator {
        static void validateRange(int ans) {
            if (ans < 100 || ans > 999)
                throw new IllegalArgumentException();
        }
        static void validateDigit(List<Integer> user, int num) {
            if (num == 0 || user.contains(num))
                throw new IllegalArgumentException();
        }
    }
}
