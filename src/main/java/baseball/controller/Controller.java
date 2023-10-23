package baseball.controller;

import baseball.domain.Baseball;
import baseball.domain.Computer;
import baseball.domain.GameResult;
import baseball.domain.Player;
import baseball.view.OutputView;
import java.util.List;

public class Controller {
    private final Baseball baseball;
    private final Computer computer;
    private final Player player;
    private final OutputView outputView;

    public Controller() {
        this.baseball = new Baseball();
        this.computer = new Computer();
        this.outputView = new OutputView();
        this.player = new Player();
    }

    public void playGame() {
        List<Integer> computerNumber = computer.createNumber();
        GameResult gameResult = GameResult.initialResult();

        while (!gameResult.isGameOver()) {
            List<Integer> playerNumber = player.getInputNumber();
            gameResult = baseball.checkInput(computerNumber, playerNumber);
            outputView.result(gameResult);
        }

        outputView.endGame();

        int option = player.receiveRetryOption();
        if (option == 1) {
            playGame();
        }
    }
}



