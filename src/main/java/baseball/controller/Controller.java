package baseball.controller;

import baseball.model.GameCompare;
import baseball.view.InputView;
import baseball.view.OutputView;
import baseball.model.Player;

public class Controller {

    private static final String GAME_RESTART = "1";
    private static final String GAME_END = "2";

    private final InputView inputView;
    private final OutputView outputView;

    public Controller() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    private boolean isGameFinished = false;

    public void play() {
        Player player = new Player();
        outputView.printStartGame();
        while (true) {
            GameCompare gameCompare = new GameCompare();
            playGame(player, gameCompare);
            String inputNumber = inputView.reStart();
            if (isReStart(inputNumber)) {
                break;
            }
        }
    }

    private boolean isReStart(String inputNumber) {
        if (inputNumber.equals(GAME_RESTART)) {
            isGameFinished = false;
        }
        if (inputNumber.equals(GAME_END) ) {
            return true;
        }
        return false;
    }

    private void playGame(Player player, GameCompare gameCompare) {
        while (!isGameFinished) {
            String inputNumber = inputView.inputNumber();
            player.updateNumbers(inputNumber);
            boolean endGameSign = gameCompare.updateGameCompare(player);
            String result = gameCompare.showResult();
            OutputView.showResult(result);
            isGameFinished = endGameSign;
            if (Boolean.TRUE.equals(endGameSign)) {
                break;
            }
        }
    }
}