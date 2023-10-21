package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.service.BaseballGame;
import baseball.utils.Utils;
import baseball.view.InputView;
import java.util.List;

public class controller {
    private Computer computer = new Computer();
    private Player player = new Player();
    private BaseballGame baseballGame = new BaseballGame();

    public void startGame() {
        setUpBaseballGame();
    }

    public void setUpBaseballGame() {
        computer.setBaseballNumbers(baseballGame.createComputerNumbers());
        List<Integer> playerNumbers = Utils.parseIntegerList(InputView.inputBaseballNumbers());
        player.setBaseballNumbers(playerNumbers);
    }
}
