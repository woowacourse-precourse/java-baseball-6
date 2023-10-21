package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.service.BaseballGame;
import baseball.utils.Utils;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

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
        List<Integer> playerNumbers = Utils.parseIntegerList(InputView.inputBaseballNumbers());
        player.setBaseballNumbers(playerNumbers);

        baseballGame.calculateNumbers(computer.getBaseballNumbers(), player.getBaseballNumbers());
        OutputView.printCalculateResult(baseballGame.ballCount, baseballGame.strikeCount);
    }

    public void selectGameState() {
        OutputView.printRestartOrQuit();
        int gameStateNumber = Integer.parseInt(InputView.inputGameStateNumber());
        if (gameStateNumber == 1) {
            run();
        }
        if (gameStateNumber == 2) {
            return;
        }
    }
}
