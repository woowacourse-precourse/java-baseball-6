package baseball.util;

import baseball.domain.BaseballNumbers;

/**
 * 컴퓨터의 난수를 만드는 클래스.
 */
public class Computer {

    public static BaseballNumbers generateComputerNumbers() {
        return GameFactory.createComputerNumbers();
    }
}
