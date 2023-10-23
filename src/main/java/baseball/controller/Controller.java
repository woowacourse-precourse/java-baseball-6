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
    private final InputView inputView;
    private final OutputView outputView;
    private final Player player;

    public Controller(Baseball baseball, Computer computer, InputView inputView, OutputView outputView, Player player) {
        this.baseball = baseball;
        this.computer = computer;
        this.inputView = inputView;
        this.outputView = outputView;
        this.player = player;
    }

    public void playGame() {
        List<Integer> computerNumber = computer.createNumber();
        GameResult gameResult = GameResult.initialResult();

        while (!gameResult.isGameOver()) {
            outputView.requestNumber();
            String playerInput = inputView.getInputNumber();
            List<Integer> playerNumber = player.getInputNumber(playerInput);
            gameResult = baseball.checkInput(computerNumber, playerNumber);
            outputView.result(gameResult);
        }

        outputView.endGame();
        outputView.restartOrQuit();
        String retryOptionInput = inputView.getInputNumber();
        int option = player.receiveRetryOption(retryOptionInput);

        if (option == RESTART) {
            playGame();
        }
    }
}



