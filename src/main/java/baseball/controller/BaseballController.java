package baseball.controller;

import baseball.model.BaseballGame;
import baseball.model.Player;
import baseball.model.dto.BaseballGameResult;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballController {

    private static final String GAME_END = "2";

    private final InputView inputView;
    private final OutputView outputView;

    public BaseballController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    private static boolean isGameEnd(final boolean endGameSign) {
        return Boolean.TRUE.equals(endGameSign);
    }

    public void play() {
        Player player = new Player();
        outputView.printStartGame();

        while (true) {
            BaseballGame baseballGame = new BaseballGame();
            playGame(player, baseballGame);
            String inputNumber = inputView.reStart();

            if (isEnd(inputNumber)) {
                break;
            }
        }
    }

    private void playGame(final Player player, final BaseballGame baseballGame) {
        while (true) {
            String inputNumber = inputView.inputNumber();
            player.updateNumbers(inputNumber);
            boolean endGameSign = baseballGame.updateGameCompare(player);
            BaseballGameResult baseballGameResult = new BaseballGameResult(baseballGame);
            outputView.showResult(baseballGameResult);

            if (isGameEnd(endGameSign)) {
                break;
            }
        }
    }

    private boolean isEnd(final String inputNumber) {
        return inputNumber.equals(GAME_END);
    }
}
