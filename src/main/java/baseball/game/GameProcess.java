package baseball.game;

import baseball.NumberFactory;
import baseball.error.ErrorCode;
import baseball.view.View;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class GameProcess {

    private BaseballGame baseballGame;

    public void process() {
        View.startGame();
        init();
        do {
            inputUserNumber();
        } while (inputRestartNumber());

        View.endGame();
    }

    private void init() {
        List<Integer> numbers = NumberFactory.createNumbers(GameConfig.SIZE, GameConfig.START_INCLUSIVE, GameConfig.END_INCLUSIVE);
        this.baseballGame = new BaseballGame(numbers);
    }

    private void inputUserNumber() {
        while (baseballGame.getStrike() != GameConfig.SIZE) {
            View.printUserInput();
            String userInput = Console.readLine();

            baseballGame.tryUserInput(userInput);
            System.out.println(baseballGame.getStrike() + " " + baseballGame.getBall());
            View.printHint(baseballGame.getStrike(), baseballGame.getBall());
        }
    }

    private boolean inputRestartNumber() {
        View.restartGame();
        String inputNumber = Console.readLine();

        int number = valid(inputNumber);
        if (number == GameConfig.RESTART_NUMBER) {
            init();
            return true;
        }
        return false;
    }

    private int valid(String inputNumber) {
        String RestartButton = String.valueOf(GameConfig.RESTART_NUMBER);
        String EndButton = String.valueOf(GameConfig.END_NUMBER);

        if (!inputNumber.equals(RestartButton) && !inputNumber.equals(EndButton)) {
            throw new IllegalArgumentException(ErrorCode.RESTART_ERROR.message);
        }
        return Integer.parseInt(inputNumber);
    }
}
