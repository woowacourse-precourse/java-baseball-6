package baseball.game;

import baseball.NumberFactory;
import baseball.view.View;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Process {

    private BaseballGame baseballGame;

    public void process() {
        View.startGame();
        init();
        do {
            inputUserNumber();
        } while (isRestart());
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

    private boolean isRestart() {
        View.restartGame();
        String userInput = Console.readLine();

        int pressedNumber = baseballGame.tryAgainGame(userInput);
        if (pressedNumber == GameConfig.RESTART_NUMBER) {
            init();
            return true;
        }
        return false;
    }
}
