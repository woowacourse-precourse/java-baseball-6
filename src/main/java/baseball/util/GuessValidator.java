package baseball.util;

public class GuessValidator {
    public boolean isValidGuess(String guess) {
        if (guess.length() != 3) {
            return false;
        }
        for (int i = 0; i < guess.length(); i++) {
            char digit = guess.charAt(i);
            if (!Character.isDigit(digit)) {
                return false;
            }
        }
        return hasUniqueDigits(guess);

    }

    public boolean hasUniqueDigits(String guess) {
        for (int i = 0; i < guess.length(); i++) {
            for (int j = i + 1; j < guess.length(); j++) {
                if (guess.charAt(i) == guess.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
}
