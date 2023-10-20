package baseball.game;

import baseball.User;

import java.util.Arrays;
import java.util.List;

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
            List<Integer> userNumber = User.input3DigitNumber();
            printUserInputNumber(Arrays.toString(userNumber.toArray()));

            BaseBallGameResult result = computer.calculate(userNumber);



        }

    }
}
