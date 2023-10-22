package validate;

public class GameInputValidator {
    public void validate(String input) throws IllegalArgumentException{
        if (input == null || input.length() != 3) {
            throw new IllegalArgumentException("입력은 3개의 숫자로 이루어져야 합니다.");
        }

        if (input.contains(" ")) {
            throw new IllegalArgumentException("입력에 공백이 포함되면 안 됩니다.");
        }

        if (input.chars().distinct().count() != input.length()) {
            throw new IllegalArgumentException("입력의 숫자들은 중복되면 안 됩니다.");
        }

        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("입력은 숫자로만 이루어져야 합니다.");
            }
        }
    }
}
