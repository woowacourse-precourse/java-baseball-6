package baseball.service;

import baseball.domain.BallCount;
import baseball.utility.ArrayConverter;
import baseball.utility.RandomNumberGenerator;

import java.util.List;

import static baseball.configuration.RandomNumberConfig.COUNT;

public class BaseballGameServiceImpl implements BaseballGameService {

    private List<Integer> computerNumbers;
    BallCount ballCount;

    public void setComputerNumbers() {
        computerNumbers = RandomNumberGenerator.generateNotDuplicatedRandomNumbers();
    }

    public BallCount playGame(String inputNumbers) {
        int[] arrayNumbers = ArrayConverter.toIntArray(inputNumbers);
        ballCount = new BallCount();

        for (int i = 0; i < COUNT; i++) {
            matchNumbers(i, arrayNumbers[i]);
        }

        return ballCount;
    }

    private void matchNumbers(int i, int arrayNumber) {
        for (int j = 0; j < COUNT; j++) {
            if (arrayNumber == computerNumbers.get(j)) {
                increaseCount(i, j);
            }
        }
    }

    private void increaseCount(int i, int j) {
        if (i == j) {
            ballCount.increaseStrike();
            return;
        }

        ballCount.increaseBall();
    }

}
