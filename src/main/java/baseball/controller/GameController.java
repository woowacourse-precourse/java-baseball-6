package baseball.controller;

import baseball.model.Computer;
import baseball.util.BaseballNumberGenerator;
import baseball.util.BaseballRandomNumberGenerator;

public class GameController {
    private final static BaseballNumberGenerator baseballNumberGenerator = new BaseballRandomNumberGenerator();
    private final static Computer computer = new Computer(baseballNumberGenerator.generate());

}
