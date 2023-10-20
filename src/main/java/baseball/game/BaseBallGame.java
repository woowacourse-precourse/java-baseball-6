package baseball.game;

import baseball.User;

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

        while (true) {
            printUserInputMessage();
            String userNumber = User.input3DigitNumber();
            printUserInputNumber(userNumber);
        }

    }
}
