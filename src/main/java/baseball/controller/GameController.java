package baseball.controller;

import baseball.constant.GameConstant;
import baseball.model.Computer;
import baseball.model.Player;
import baseball.util.StrikeAndBallCounter;
import baseball.view.ComputerView;
import baseball.view.InputView;
import java.util.ArrayList;
import java.util.List;

public class GameController {

    private final InputView inputView = new InputView();
    private final ComputerView computerView = new ComputerView();
    private Player player = new Player();
    private Computer computer = new Computer();
    private List<Integer> strikeAndBall = new ArrayList<>();
    private Boolean isGameOver = false;

    public void startGame() {
        computer.setComputerGameNumber();

        while (!isGameOver) {
            getPlayerInput();
            countBallAndStrike();
            printGameResult();
        }
    }

    private void getPlayerInput() {
        player.setPlayerGameNumber(inputView.getPlayerInput());
    }

    private void countBallAndStrike() {
        strikeAndBall = StrikeAndBallCounter.countStrikeAndBall(player.getPlayerGameNumber(),
                computer.getComputerGameNumber());
    }

    private void printGameResult() {
        if (strikeAndBall.get(GameConstant.STRIKE_INDEX) == GameConstant.THREE_STRIKE) {
            computerView.printWinResult();
            askRestart();
        } else {
            computerView.printLostResult(strikeAndBall);
        }
    }

    private void askRestart() {
        Integer restart = inputView.getRestart();
        if (restart == 1) {
            isGameOver = false;
        } else {
            isGameOver = true;
        }
    }

    public GameController() {
        computerView.printGameStart();
    }
}