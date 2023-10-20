package baseball.game;

import baseball.User;

import java.util.List;

import static baseball.view.Console.*;


public class BaseBallGame implements Game {

    private final Computer computer;
    private final String NOT_NUMBER_PATTERN;
    private final String NO_CHARACTER;
    private boolean playing;

    public BaseBallGame() {
        this.computer = new Computer();
        this.NOT_NUMBER_PATTERN = "[^0-9]";
        this.NO_CHARACTER = "";
        this.playing = true;
    }

    @Override
    public void play() {
        printGameStart();
        computer.createRandomNumber();

        while (playing) {
            printUserInputMessage();
            List<Integer> userNumber = User.input3DigitNumber();
            printUserInputNumber(userNumber.toString().replaceAll(NOT_NUMBER_PATTERN, NO_CHARACTER));

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
