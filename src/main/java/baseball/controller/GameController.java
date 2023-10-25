package baseball.controller;

import baseball.constant.Rule;
import baseball.model.Computer;
import baseball.model.Game;
import baseball.model.Player;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class GameController {

    private InputView inputView;
    private OutputView outputView;
    private Game game;
    private Player player;
    private Computer computer;

    public GameController() {
        inputView = new InputView();
        outputView = new OutputView();
        game = new Game();
        player = new Player();
        computer = new Computer();
    }

    public void start() {
        boolean isCompleted = false;
        List<Integer> randomNum = computer.createRandomNum();

        while (!isCompleted) {
            game.initGame();
            inputView.printInputMessage();
            List<Integer> playerNum = player.inputPlayerNum();
            game.comparePlayerToComputer(playerNum,randomNum);
            outputView.printResultMessage(game.createResultMessage());
            isCompleted = game.isCompleted();
        }

        outputView.printSuccessMessage();
        restartOrEnd();
    }

    private void restartOrEnd() {

        inputView.printRestartOrEnd();
        String isStart = player.inputRestartOrEnd();

        if(isStart.equals(Rule.RESTART_NUM)) {
            start();
        }

    }

    public void getStartMessage() {
        outputView.printStartMessage();
    }
}
