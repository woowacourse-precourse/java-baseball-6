package baseball.policy;

public class ValidationPolicy {
    public boolean isCorrectLength(String input, int length){
        return input.length() == length;
    }

    public boolean isNumericString(String input) {
        if (input == null || input.isEmpty()) {
            return false;
        }

        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }

        return true;
    }

    public boolean hasNoDuplicateNumber(String input) {
        if (input == null || input.isEmpty()) {
            return true;
        }

        for (int i = 0; i < input.length(); i++) {
            char digit = input.charAt(i);
            for (int j = i + 1; j < input.length(); j++) {
                if (digit == input.charAt(j)) {
                    return false;
                }
            }
        }

        return true;
    }
}
