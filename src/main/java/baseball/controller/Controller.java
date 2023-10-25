package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.service.BaseballGame;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Controller {
    private static final int RESTART_GAME = 1;
    private static final int QUIT_GAME = 2;
    private static final int STRIKE_COUNT_THREE = 3;
    private Computer computer = new Computer();
    private Player player = new Player();
    private BaseballGame baseballGame = new BaseballGame();

    public void run() {
        OutputView.printStartGame();
        playGame();
    }

    public void playGame() {
        computer.setComputerNumbers(baseballGame.createComputerNumbers());
        while (true) {
            OutputView.printInputNumbers();
            player.setPlayerNumbers(InputView.inputBaseballNumbers());

            baseballGame.calculateNumbers(computer.getComputerNumbers(), player.getPlayerNumbers());
            OutputView.printCalculateResult(baseballGame.ballCount, baseballGame.strikeCount);

            if (baseballGame.strikeCount == STRIKE_COUNT_THREE) {
                OutputView.printSuccess();
                break;
            }
        }
        selectGameState();
    }

    public void selectGameState() {
        OutputView.printRestartOrQuit();
        int gameStateNumber = InputView.inputGameStateNumber();
        if (gameStateNumber == RESTART_GAME) {
            playGame();
        }
        if (gameStateNumber == QUIT_GAME) {
            return;
        }
    }
}
