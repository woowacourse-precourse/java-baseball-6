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
        startGame();

        while (true) {
            PlayGame();
            if (baseballGame.strikeCount == 3) {
                OutputView.printSuccess();
                break;
            }
        }
        selectGameState();
    }

    public void startGame() {
        OutputView.printStartGame();
        computer.setBaseballNumbers(baseballGame.createComputerNumbers());
    }

    public void PlayGame() {
        OutputView.printInput();
        player.setBaseballNumbers(InputView.inputBaseballNumbers());

        baseballGame.calculateNumbers(computer.getBaseballNumbers(), player.getBaseballNumbers());
        OutputView.printCalculateResult(baseballGame.ballCount, baseballGame.strikeCount);
    }


    public void selectGameState() {
        OutputView.printRestartOrQuit();
        int gameStateNumber = InputView.inputGameStateNumber();
        if (gameStateNumber == RESTART_GAME) {
            run();
        }
        if (gameStateNumber == QUIT_GAME) {
            return;
        }
    }
}
