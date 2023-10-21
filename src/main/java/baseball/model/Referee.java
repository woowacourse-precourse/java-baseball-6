package baseball.model;

public class Referee {

    public int calculateStrikeNumbers(String randomNumbers, String inputNumbers) {
        int strikeNumbers = 0;
        for (int i = 0; i < Constants.NUMBER_OF_NUMBERS; i++) {
            if (isSameNumberInSamePlace(randomNumbers.charAt(i), inputNumbers.charAt(i))) {
                strikeNumbers++;
            }
        }
        return strikeNumbers;
    }

    public int calculateBallNumbers(String randomNumbers, String inputNumbers) {
        int ballNumbers = 0;
        for (int i = 0; i < Constants.NUMBER_OF_NUMBERS; i++) {
            if (isRandomNumbersContainInputNumber(randomNumbers, inputNumbers.charAt(i))
                    && !isSameNumberInSamePlace(randomNumbers.charAt(i), inputNumbers.charAt(i))) {
                ballNumbers++;
            }
        }
        return ballNumbers;
    }

    public boolean isNothing(int strikeNumbers, int ballNumbers) {
        return strikeNumbers == Constants.ZERO && ballNumbers == Constants.ZERO;
    }

    public boolean isOnlyBall(int strikeNumbers, int ballNumbers) {
        return strikeNumbers == Constants.ZERO && ballNumbers != Constants.ZERO;
    }

    public boolean isOnlyStrike(int strikeNumbers, int ballNumbers) {
        return strikeNumbers != Constants.ZERO && ballNumbers == Constants.ZERO;
    }

    public boolean isStrikeAndBall(int strikeNumbers, int ballNumbers) {
        return strikeNumbers != Constants.ZERO && ballNumbers != Constants.ZERO;
    }

    public boolean isThreeStrike(int strikeNumbers) {
        return strikeNumbers == Constants.THREE_STRIKE;
    }

    private boolean isRandomNumbersContainInputNumber(String randomNumbers, char inputNumber) {
        for (int i = 0; i < Constants.NUMBER_OF_NUMBERS; i++) {
            if (isSameNumberInSamePlace(randomNumbers.charAt(i), inputNumber)) {
                return true;
            }
        }
        return false;
    }

    private boolean isSameNumberInSamePlace(char randomNumber, char inputNumber) {
        return randomNumber == inputNumber;
    }
}
