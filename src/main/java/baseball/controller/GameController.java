package baseball.controller;

import baseball.model.Computer;
import baseball.model.Game;
import baseball.model.User;

import java.util.List;

public class GameController {
    private final Computer computer;
    private final Game game;
    private final User user;

    public GameController() {
        this.computer = new Computer();
        this.game = new Game();
        this.user = new User();
    }

    public void start() {
        List<Integer> computerRandomNum = computer.makeRandomNumber();
        while(true) {
            List<Integer> userInputNum = user.inputGameNumber();

            int strike = game.setGameResult(userInputNum, computerRandomNum);
            if(strike == 3) {
                game.end();
                break;
            }
        }
    }

    public Boolean isReStart() {
        String restartNum = user.inputRestartNumber();
        return game.checkRestart(restartNum);
    }


}
