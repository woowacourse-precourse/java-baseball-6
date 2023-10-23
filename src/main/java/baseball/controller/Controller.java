package baseball.controller;

import baseball.constant.Constant;
import baseball.domain.Baseball;
import baseball.domain.Computer;
import baseball.domain.GameResult;
import baseball.domain.Player;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class Controller {
    private final int RESTART = Constant.RESTART.getConstant();

    private final Baseball baseball;
    private final Computer computer;
    private final Player player;
    private final InputView inputView;
    private final OutputView outputView;

    public Controller() {
        this.baseball = new Baseball();
        this.computer = new Computer();
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.player = new Player();
    }

    public void playGame() {
        List<Integer> computerNumber = computer.createNumber();
        GameResult gameResult = GameResult.initialResult();

        while (!gameResult.isGameOver()) {
            outputView.requestNumber();
            String playerInput = inputView.receiveInputNumber();
            List<Integer> playerNumber = player.getInputNumber(playerInput);
            gameResult = baseball.checkInput(computerNumber, playerNumber);
            outputView.result(gameResult);
        }

        outputView.endGame();
        outputView.restartOrQuit();
        String retryOptionInput = inputView.receiveInputNumber();
        int option = player.receiveRetryOption(retryOptionInput);

        if (option == RESTART) {
            playGame();
        }
    }
}



