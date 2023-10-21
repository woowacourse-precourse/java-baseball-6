package baseball.model;

import java.util.stream.IntStream;

public class Referee {

    public int calculateStrikeNumbers(String randomNumbers, String inputNumbers) {
        return (int) IntStream.range(Constants.ZERO, Constants.NUMBER_OF_NUMBERS)
                .filter(i -> isSameNumberInSamePlace(randomNumbers.charAt(i), inputNumbers.charAt(i)))
                .count();
    }

    public int calculateBallNumbers(String randomNumbers, String inputNumbers) {
        return (int) IntStream.range(Constants.ZERO, Constants.NUMBER_OF_NUMBERS)
                .filter(i -> isRandomNumbersContainInputNumber(randomNumbers, inputNumbers.charAt(i)))
                .filter(i -> !isSameNumberInSamePlace(randomNumbers.charAt(i), inputNumbers.charAt(i)))
                .count();
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
        return randomNumbers.chars()
                .mapToObj(c -> (char) c)
                .anyMatch(singleNumber -> isSameNumberInSamePlace(singleNumber, inputNumber));
    }

    private boolean isSameNumberInSamePlace(char randomNumber, char inputNumber) {
        return randomNumber == inputNumber;
    }
}
