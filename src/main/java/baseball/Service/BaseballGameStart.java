package baseball.Service;

import baseball.Dto.RandomNumbers;

public class BaseballGameStart {
    public void run() {
        createRandomNumbers();
    }

    private void createRandomNumbers() {
        RandomNumbers randomNumbers = RandomNumbers.getInstance();
        randomNumbers.generateNewRandomNumbers();
    }
}
