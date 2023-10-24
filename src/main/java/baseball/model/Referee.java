package baseball.model;

import java.util.stream.IntStream;

public class Referee {

    private int strikeNumber;
    private int ballNumber;

    public void calculateBallAndStrikeNumber(String randomNumbers, String inputNumbers) {
        strikeNumber = calculateStrikeNumbers(randomNumbers, inputNumbers);
        ballNumber = calculateBallNumbers(randomNumbers, inputNumbers);
    }

    public void setUpGame() {
        strikeNumber = Constants.ZERO;
        ballNumber = Constants.ZERO;
    }

    public boolean isNothing() {
        return strikeNumber == Constants.ZERO && ballNumber == Constants.ZERO;
    }

    public boolean isOnlyBall() {
        return strikeNumber == Constants.ZERO && ballNumber != Constants.ZERO;
    }

    public boolean isOnlyStrike() {
        return strikeNumber != Constants.ZERO && ballNumber == Constants.ZERO;
    }

    public boolean isStrikeAndBall() {
        return strikeNumber != Constants.ZERO && ballNumber != Constants.ZERO;
    }

    public boolean isThreeStrike() {
        return strikeNumber == Constants.THREE_STRIKE;
    }

    public int getStrikeNumber() {
        return strikeNumber;
    }

    public int getBallNumber() {
        return ballNumber;
    }

    private int calculateStrikeNumbers(String randomNumbers, String inputNumbers) {
        return (int) IntStream.range(Constants.ZERO, Constants.NUMBER_OF_NUMBERS)
                .filter(i -> isSameNumberInSamePlace(randomNumbers.charAt(i), inputNumbers.charAt(i)))
                .count();
    }

    private int calculateBallNumbers(String randomNumbers, String inputNumbers) {
        return (int) IntStream.range(Constants.ZERO, Constants.NUMBER_OF_NUMBERS)
                .filter(i -> isRandomNumbersContainInputNumber(randomNumbers, inputNumbers.charAt(i)))
                .filter(i -> !isSameNumberInSamePlace(randomNumbers.charAt(i), inputNumbers.charAt(i)))
                .count();
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
