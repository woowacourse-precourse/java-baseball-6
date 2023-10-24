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
        for (char charNum : guessNumberArray) {
            if (!isCharNumber(charNum)) {
                throw new IllegalArgumentException("숫자만 입력해야 합니다.");
            }
        }
    }

    private void isGuessNumberSame(char[] guessNumberArray) {
        if (guessNumberArray[0] == guessNumberArray[1] || guessNumberArray[1] == guessNumberArray[2]
                || guessNumberArray[2] == guessNumberArray[0]) {
            throw new IllegalArgumentException("서로 다른 숫자만 입력해야 합니다.");
        }
    }

    public void isValidReGameOptionNumber(String reGameNumberString) throws IllegalArgumentException {
        if (reGameNumberString.length() != 1) {
            throw new IllegalArgumentException("1 혹은 2를 입력해 주세요.");
        }
        char charNum = reGameNumberString.charAt(0);
        if (!(charNum == '1' || charNum == '2')) {
            throw new IllegalArgumentException("1 혹은 2를 입력해 주세요.");
        }
        return;
    }

    public boolean isCharNumber(char charNum) {
        if ('1' > charNum || '9' < charNum) {
            return false;
        }
        return true;
    }
}
