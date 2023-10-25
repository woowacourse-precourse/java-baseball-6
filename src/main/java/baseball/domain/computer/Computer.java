package baseball.domain.computer;

import baseball.domain.baseballnumber.BaseballNumbers;

public class Computer {

    private final BaseballNumbers numbers;

    public Computer(BaseballNumbers randomNumbers) {
        numbers = randomNumbers;
    }

    public BaseballNumbers numbers() {
        return numbers;
    }
}
