package baseball.model;

import java.util.stream.IntStream;

public class Referee {

    private final int strikeNumber;
    private final int ballNumber;

    private Referee(final int strikeNumber, final int ballNumber) {
        this.strikeNumber = strikeNumber;
        this.ballNumber = ballNumber;
    }

    public static Referee calculateBallAndStrikeNumber(String randomNumbers, String inputNumbers) {
        return new Referee(calculateStrikeNumbers(randomNumbers, inputNumbers),
                calculateBallNumbers(randomNumbers, inputNumbers));
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

    private static int calculateStrikeNumbers(String randomNumbers, String inputNumbers) {
        return (int) IntStream.range(Constants.ZERO, Constants.NUMBER_OF_NUMBERS)
                .filter(index -> isSameNumberInSamePlace(randomNumbers.charAt(index), inputNumbers.charAt(index)))
                .count();
    }

    private static int calculateBallNumbers(String randomNumbers, String inputNumbers) {
        return (int) IntStream.range(Constants.ZERO, Constants.NUMBER_OF_NUMBERS)
                .filter(inputNumbersIndex ->
                        isRandomNumbersContainInputNumber(randomNumbers, inputNumbers.charAt(inputNumbersIndex)))
                .filter(index -> !isSameNumberInSamePlace(randomNumbers.charAt(index), inputNumbers.charAt(index)))
                .count();
    }

    private static boolean isRandomNumbersContainInputNumber(String randomNumbers, char inputNumber) {
        return randomNumbers.chars()
                .mapToObj(intStreamToCharacter -> (char) intStreamToCharacter)
                .anyMatch(singleNumber -> isSameNumberInSamePlace(singleNumber, inputNumber));
    }

    private static boolean isSameNumberInSamePlace(char randomNumber, char inputNumber) {
        return randomNumber == inputNumber;
    }
}
