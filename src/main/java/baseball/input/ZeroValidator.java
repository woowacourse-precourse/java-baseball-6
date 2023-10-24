package baseball.input;

public class ZeroValidator {
    public static boolean isValid(String input) {
        return input.chars().allMatch(c -> c != '0');
    }
}
