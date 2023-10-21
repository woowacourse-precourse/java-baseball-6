package baseball.service;

import baseball.utils.RandomNumberGenerator;

public class BaseballService {

    private final RandomNumberGenerator randomNumberGenerator;

    public BaseballService(final RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void saveRandomNumbers() {
        randomNumberGenerator.generateNumbers();
    }
}
