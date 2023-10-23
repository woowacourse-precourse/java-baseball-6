package baseball;

public class InputValidator {

    public InputValidator() {
    }

    public void isValidGuessNumber(String guessNumberString) throws IllegalArgumentException {
        if (guessNumberString.length() != 3) {
            throw new IllegalArgumentException();
        }
        char[] guessNumberArray = guessNumberString.toCharArray();
        isGuessNumberSame(guessNumberArray);
        isGuessNumberCharacter(guessNumberArray);
        return;
    }

    private void isGuessNumberCharacter(char[] guessNumberArray) {
        for (char c : guessNumberArray) {
            if (!isCharNumber(c)) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void isGuessNumberSame(char[] guessNumberArray) {
        if (guessNumberArray[0] == guessNumberArray[1] || guessNumberArray[1] == guessNumberArray[2]
                || guessNumberArray[2] == guessNumberArray[0]) {
            throw new IllegalArgumentException();
        }
    }

    public void isValidReGameOptionNumber(String reGameNumberString) throws IllegalArgumentException {
        if (reGameNumberString.length() != 1) {
            throw new IllegalArgumentException();
        }
        char c = reGameNumberString.charAt(0);
        if (!(c == '1' || c == '2')) {
            throw new IllegalArgumentException();
        }
        return;
    }

    public boolean isCharNumber(char c) {
        if ('1' > c || '9' < c) {
            return false;
        }
        return true;
    }
}
