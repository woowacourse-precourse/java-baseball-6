package baseball.util;

import baseball.domain.BaseballNumbers;

public class Computer {

    public static BaseballNumbers generateComputerNumbers() {
        return GameFactory.createComputerNumbers();
    }
}
