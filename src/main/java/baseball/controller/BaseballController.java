package baseball.controller;

import baseball.model.BaseballGame;
import baseball.model.Player;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballController {

    private static final String GAME_RESTART = "1";
    private static final String GAME_END = "2";

    private final InputView inputView;
    private final OutputView outputView;

    public BaseballController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void play() {
        Player player = new Player();
        outputView.printStartGame();
        while (true) {
            BaseballGame baseballGame = new BaseballGame();
            playGame(player, baseballGame);
            String inputNumber = inputView.reStart();
            if (isReStart(inputNumber)) {
                break;
            }
        }
    }

    private void playGame(Player player, BaseballGame baseballGame) {
        while (true) {
            String inputNumber = inputView.inputNumber();
            player.updateNumbers(inputNumber);
            boolean endGameSign = baseballGame.updateGameCompare(player);
            String gameResult = baseballGame.showResult();
            OutputView.showResult(gameResult);
            if (isGameEnd(endGameSign)) {
                break;
            }
        }
    }

    private boolean isReStart(String inputNumber) {
        if (inputNumber.equals(GAME_RESTART)) {
            return false;
        }
        if (inputNumber.equals(GAME_END)) {
            return true;
        }
        return false;
    }

    private static boolean isGameEnd(boolean endGameSign) {
        return Boolean.TRUE.equals(endGameSign);
    }
}
