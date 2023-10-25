package baseball.number;

import baseball.invalid.InvalidIntegerLengthException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;




public class BaseBallNumbers {
    private static final int START_INCLUSIVE = 0;
    private static final int END_INCLUSIVE = 2;
    private static final int BASEBALL_NUMBERS_LENGTH = 3;
    private static List<BaseBallNumber> userBaseballNumbers;

    public BaseBallNumbers(String userNumbers) {
        validateUserNumbers(userNumbers);
        this.userBaseballNumbers = convertBaseBallNumberFormat(userNumbers);
    }

    private List<BaseBallNumber> convertBaseBallNumberFormat(String userNumbers) {
        List<BaseBallNumber> userNumbersList = new ArrayList<>();
        for (int i = 0; i < userNumbers.length(); i++) {
            userNumbersList.add(new BaseBallNumber(userNumbers.charAt(i)));
        }
        return userNumbersList;
    }

    private void validateUserNumbers(String userNumbers) {
        if (userNumbers.length() != BASEBALL_NUMBERS_LENGTH) {
            throw new InvalidIntegerLengthException();
        }
    }

    public int calculateBallCount(List<BaseBallNumber> randomNumbers) {
        return (int) IntStream.rangeClosed(START_INCLUSIVE, END_INCLUSIVE)
                .filter(i -> isBall(i, randomNumbers)).count();
    }

    private boolean isBall(int targetIndex, List<BaseBallNumber> randomNumbers) {
        BaseBallNumber randomBaseBallNumber = randomNumbers.get(targetIndex);
        BaseBallNumber userBaseBallNumber = userBaseballNumbers.get(targetIndex);
        return !randomBaseBallNumber.equals(userBaseBallNumber) && contains(randomBaseBallNumber);
    }

    public int calculateStrikeCount(List<BaseBallNumber> randomNumbers) {
        return (int) IntStream.rangeClosed(START_INCLUSIVE, END_INCLUSIVE)
                .filter(i -> isStrike(i, randomNumbers)).count();
    }

    private boolean isStrike(int targetIndex, List<BaseBallNumber> randomNumbers) {
        BaseBallNumber randomBaseBallNumber = randomNumbers.get(targetIndex);
        BaseBallNumber userBaseBallNumber = userBaseballNumbers.get(targetIndex);
        return randomBaseBallNumber.equals(userBaseBallNumber);
    }

    public boolean contains(BaseBallNumber compareBaseBallNumber) {
        return userBaseballNumbers.stream()
                .anyMatch(baseBallNumber -> baseBallNumber.equals(compareBaseBallNumber));
    }
}
