package baseball.game;

import baseball.User;

import java.util.List;

import static baseball.view.Console.*;


public class BaseBallGame implements Game {

    private final Computer computer;
    private final String NOT_NUMBER_PATTERN;
    private final String NO_CARACTER;
    public BaseBallGame() {
        this.computer = new Computer();
        this.NOT_NUMBER_PATTERN = "[^0-9]";
        this.NO_CARACTER = "";
    }

    @Override
    public void play() {
        printGameStart();
        computer.createRandomNumber();

        while (true) {
            printUserInputMessage();
            List<Integer> userNumber = User.input3DigitNumber();
            printUserInputNumber(userNumber.toString().replaceAll(NOT_NUMBER_PATTERN,NO_CARACTER));

            BaseBallGameResult result = computer.calculate(userNumber);
            printGameResult(result);


        }

    }
}
