package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.service.BaseballGame;
import baseball.utils.Utils;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class Controller {
    private Computer computer = new Computer();
    private Player player = new Player();
    private BaseballGame baseballGame = new BaseballGame();

    public void run() {
        startGame();
        PlayGame();
    }

    public void startGame() {
        OutputView.printStartGame();
        computer.setBaseballNumbers(baseballGame.createComputerNumbers());
        OutputView.printInput();
        List<Integer> playerNumbers = Utils.parseIntegerList(InputView.inputBaseballNumbers());
        player.setBaseballNumbers(playerNumbers);
    }

    public void PlayGame() {
        baseballGame.calculateNumbers(computer.getBaseballNumbers(), player.getBaseballNumbers());
        OutputView.printCalculateResult(baseballGame.ballCount, baseballGame.strikeCount);
    }
}
