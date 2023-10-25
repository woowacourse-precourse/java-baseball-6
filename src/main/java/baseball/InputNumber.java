package baseball;

public class InputNumber {

    public boolean isValidGuess(String guess) {
        if (guess.length() != 3) {
            return false;
        }

        try {
            Integer.parseInt(guess);
        } catch (NumberFormatException e) {
            return false;
        }

        return guess.chars().distinct().count() == 3;
    }
}
