package baseball.model;

public class Referee {

    public int calculateStrikeNumbers(String randomNumbers, String inputNumbers) {
        int strikeNumbers = 0;
        for (int i = 0; i < Constants.NUMBER_OF_NUMBERS; i++) {
            if (randomNumbers.charAt(i) == inputNumbers.charAt(i)) {
                strikeNumbers++;
            }
        }
        return strikeNumbers;
    }

    public int calculateBallNumbers(String randomNumbers, String inputNumbers) {
        int ballNumbers = 0;
        for (int i = 0; i < Constants.NUMBER_OF_NUMBERS; i++) {
            if (isRandomNumbersContainInputNumber(randomNumbers, inputNumbers.charAt(i)) &&
                    randomNumbers.charAt(i) != inputNumbers.charAt(i)) {
                ballNumbers++;
            }
        }
        return ballNumbers;
    }

    private boolean isRandomNumbersContainInputNumber(String randomNumbers, char inputNumber) {
        for (int i = 0; i < Constants.NUMBER_OF_NUMBERS; i++) {
            if (randomNumbers.charAt(i) == inputNumber) {
                return true;
            }
        }
        return false;
    }
}
