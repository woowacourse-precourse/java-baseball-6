package baseball.controller;

import baseball.model.Computer;
import baseball.model.NumberComparator;
import baseball.model.Player;
import baseball.model.Result;
import baseball.utils.NumberProvider;
import baseball.utils.Validator;
import baseball.view.ConsoleView;
import java.util.List;

public class GameController {
    private static final int GAME_REFRESH_INPUT = 1;

    public void start() {
        boolean newGame = true;
        ConsoleView.printGameStart();
        while (newGame) {
            newGame = executeGame();
        }
    }

    public boolean executeGame() {
        Computer computer = new Computer(NumberProvider.createRandomNumber());
        boolean gameInProgress = true;
        while (gameInProgress) {
            Player player = createPlayer();
            NumberComparator numberComparator = new NumberComparator(player, computer);
            Result result = numberComparator.compareNumber();
            gameInProgress = isNotGameFinish(result);
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
        if (result.isExistBall()) {
            ConsoleView.printBallCount(result.getBall());
            return true;
        }
        if (result.isExistStrike()) {
            ConsoleView.printStrikeCount(result.getStrike());
            return true;
        }
        ConsoleView.printNothing();
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
