package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.service.BaseballGame;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Controller {
    private static final int RESTART_GAME = 1;
    private static final int QUIT_GAME = 2;
    private Computer computer = new Computer();
    private Player player = new Player();
    private BaseballGame baseballGame = new BaseballGame();

    public void run() {
        OutputView.printStartGame();
        playGame();
    }

    public void playGame() {
        computer.setBaseballNumbers(baseballGame.createComputerNumbers());
        while (true) {
            OutputView.printInputNumbers();
            player.setBaseballNumbers(InputView.inputBaseballNumbers());

            baseballGame.calculateNumbers(computer.getBaseballNumbers(), player.getBaseballNumbers());
            OutputView.printCalculateResult(baseballGame.ballCount, baseballGame.strikeCount);

            if (baseballGame.strikeCount == 3) {
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
