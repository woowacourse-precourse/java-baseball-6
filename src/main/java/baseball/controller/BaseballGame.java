package baseball.controller;

import baseball.common.CheckResult;
import baseball.model.Computer;
import baseball.model.Player;
import baseball.view.Input;
import baseball.view.Output;

public class BaseballGame {
    private Computer computer;
    private Player player;

    public BaseballGame() {
        this.computer = new Computer();
        this.player = new Player();
    }

    public void startGame() {
        Output.printStart();

        do {
            computer.createRandomNumbers();
            play();

            String restart = Input.restartOrNot();
            computer.setGameStatus(player.restartOrNot(restart));
        } while (!isEnd());
    }

    public void play() {
        do {
            String playerInputNumbers = Input.playerInputNumbers();
            player.setPlayerNumbers(playerInputNumbers);

            CheckResult checkResult = computer.checkPlayerNumbers(player.getPlayerNumbers());
            Output.printResult(checkResult);
            if (isAllCorrect()) {
                Output.printAllCorrect();
            }
        } while (!isAllCorrect());
    }

    public boolean isEnd() {
        return this.computer.isEnd();
    }

    public boolean isAllCorrect() {
        return this.computer.isAllCorrect();
    }
}
