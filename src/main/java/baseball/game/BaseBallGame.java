package baseball.game;

import static baseball.view.Console.printGameOver;
import static baseball.view.Console.printGameResult;
import static baseball.view.Console.printGameStart;
import static baseball.view.Console.printRestartOrTerminate;
import static baseball.view.Console.printUserInputMessage;
import static baseball.view.Console.printUserInputNumber;

import baseball.User;
import java.util.List;


public class BaseBallGame implements Game {

    private final Computer computer;
    private final String NOT_NUMBER_PATTERN;
    private final String EMPTY_STRING;
    private boolean playing;

    public BaseBallGame() {
        this.computer = new Computer();
        this.NOT_NUMBER_PATTERN = "[^0-9]";
        this.EMPTY_STRING = "";
        this.playing = true;
    }

    @Override
    public void play() {
        printGameStart();
        computer.createRandomNumber();

        while (playing) {
            printUserInputMessage();
            List<Integer> userNumber = User.input3DigitNumber();
            printUserInputNumber(userNumber.toString().replaceAll(NOT_NUMBER_PATTERN, EMPTY_STRING));

            BaseBallGameResult result = computer.calculate(userNumber);
            printGameResult(result);

            if (validateGameNotOver(result)) {
                continue;
            }

            printGameOver();

            printRestartOrTerminate();
            restartOrTerminate(User.inputRestartOrTerminate());

        }

    }

    private boolean validateGameNotOver(BaseBallGameResult result) {
        return result.getStrike() != 3;
    }

    private void restartOrTerminate(String select) {

        printUserInputNumber(select);

        switch (select) {
            case "1" -> computer.createRandomNumber();
            case "2" -> playing = false;
        }

    }

}
