package baseball.controller;

import baseball.model.Comparator;
import baseball.model.Computer;
import baseball.model.Player;
import baseball.model.Result;
import baseball.utils.NumberProvider;
import baseball.utils.Validator;
import baseball.view.ConsoleView;

import java.util.List;

public class GameController {
    private static final int GAME_REFRESH_INPUT = 1;

    public void start() {
        boolean finish = true;
        ConsoleView.printGameStart();
        while (finish) {
            finish = executeGame();
        }
    }

    public boolean executeGame() {
        Computer computer = new Computer(NumberProvider.createRandomNumber());
        boolean flag = true;
        while (flag) {
            Player player = createPlayer();
            Comparator comparator = new Comparator(player, computer);
            Result result = comparator.compare();
            flag = isNotGameFinish(result);
        }
        return isRefreshGame();
    }

    private Player createPlayer() {
        List<Integer> playerNumbers = NumberProvider.convertFrom(ConsoleView.inputThreeDigitNumber());
        Validator.verifyNumberDigit(playerNumbers);
        Validator.verifyConsistOfNumber(playerNumbers);
        Validator.verifyDuplicationNumber(playerNumbers);
        return new Player(playerNumbers);
    }

    private boolean isNotGameFinish(Result result) {
        if (result.isGameFinish()) {
            ConsoleView.printStrikeCount(result.getStrike());
            ConsoleView.printGameFinsh();
            return false;
        }
        if (result.isExistBall() && result.isExistStrike()) {
            ConsoleView.printBallAndStrikeCount(result.getBall(), result.getStrike());
            return true;
        }
        if (!result.isExistBall() && !result.isExistStrike()) {
            ConsoleView.printNothing();
            return true;
        }
        if (result.isExistBall()) {
            ConsoleView.printBallCount(result.getBall());
        }
        if (result.isExistStrike()) {
            ConsoleView.printStrikeCount(result.getStrike());
        }


        return true;
    }

    private boolean isRefreshGame() {
        int input = Integer.parseInt(ConsoleView.inputGameProgressNumber());
        Validator.verifyGameProgressInput(input);
        if (input == GAME_REFRESH_INPUT) {
            return true;
        }
        return false;
    }
}
