package baseball.service;

import baseball.domain.BallCount;
import baseball.domain.Computer;
import baseball.utility.ArrayConverter;

import java.util.List;

import static baseball.configuration.RandomNumberConfig.COUNT;

public class BaseballGameServiceImpl implements BaseballGameService {

    private BallCount ballCount;

    public Computer setComputerNumbers() {
        return Computer.generateComputer();
    }

    public BallCount playGame(Computer computer, String inputNumbers) {
        int[] arrayNumbers = ArrayConverter.toIntArray(inputNumbers);
        ballCount = new BallCount();

        for (int i = 0; i < COUNT; i++) {
            matchNumbers(computer.getComputerNumbers(), i, arrayNumbers[i]);
        }

        return ballCount;
    }

    private void matchNumbers(List<Integer> computerNumbers, int i, int arrayNumber) {
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
