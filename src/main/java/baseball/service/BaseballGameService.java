package baseball.service;

import baseball.model.Computer;
import baseball.util.RandomUtil;


public class BaseballGameService {
    private Computer computer = new Computer();
    private int ballCount;
    private int strikeCount;

    public void initGame() {
        initCount();
        setComputerInit();
    }

    private void initCount() {
        this.ballCount = 0;
        this.strikeCount = 0;
    }

    private void setComputerInit() {
        setRandomNumbers();
        computer.setGameStatusStart();
    }

    private void setRandomNumbers() {
        computer.setRandomNumbers(RandomUtil.createRandomNumber());
    }
}