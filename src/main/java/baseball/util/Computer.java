package baseball.util;

import baseball.domain.BaseballNumbers;
import baseball.util.GameFactory;

public class Computer {

    public static BaseballNumbers generateComputerNumbers() {
        return GameFactory.createComputerNumbers();
    }
}
