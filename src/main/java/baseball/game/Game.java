package baseball.game;

import baseball.player.Computer;
import baseball.player.User;

import static baseball.common.Constants.*;

public class Game {
    private Computer computer;
    private User user;
    private GameResult result;

    public Game() {
        System.out.println(GAME_START_MESSAGE);
        start();
    }

    public void start() {
        setGame();
        playGame();
        askRetry();
    }

    private void setGame() {
        computer = new Computer();
        user = new User();
        result = new GameResult();
    }

    private void playGame() {
        while (!result.isThreeStrike()) {
            user.inputNumbers();
            result.checkResult(user.getNumbers(), computer.getNumbers());
            result.printResult();
        }
        System.out.println(FINISH_GAME_MESSAGE);
    }

    private void askRetry() {
        GameCommand gameCommand = user.inputGameCommand();
        if (gameCommand.isRetry()) {
            start();
        }
    }
}
