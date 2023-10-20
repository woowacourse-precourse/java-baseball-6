package baseball.game;

import static baseball.view.Console.*;


public class BaseBallGame implements Game {

    private final Computer computer;
    public BaseBallGame() {
        this.computer = new Computer();
    }

    @Override
    public void play() {
        printGameStart();
        computer.createRandomNumber();


    }
}
