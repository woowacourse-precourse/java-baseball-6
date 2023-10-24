package baseball;

public class InputCheck {
    public static boolean check(String input) {
        if (sizeCheck(input) == false) {
            return false;
        }
        if (numberCheck(input) == false) {
            return false;
        }
        return true;
    }

    // size check
    private static boolean sizeCheck(String input) {
        if (input.length() != 3) {
            return false;
        }
        return true;
    }

    // number duplicate check
    private static boolean numberCheck(String input) {
        if (input.charAt(0) == input.charAt(1)) {
            return false;
        }
        if (input.charAt(0) == input.charAt(2)) {
            return false;
        }
        if (input.charAt(1) == input.charAt(2)) {
            return false;
        }
        return true;
    }
}
