package baseball.Controller;

import baseball.Model.Computer;
import baseball.Model.Helper;
import baseball.Model.Status;
import baseball.Model.User;
import baseball.View.GameView;
import java.util.ArrayList;
import java.util.List;

public class GameController {
    GameView gameView = new GameView();
    private Status status;

    public GameController() {
        this.status = status.GAME_START;
    }

    public void startGame() {
        gameView.printStartMessage();
        while (status != status.GAME_END) {
            Computer computer = Computer.createByRandomNumber();
            playGame(computer);
            status = Status.choiceGame(gameView.printGameOverMessage());
        }
    }

    public void playGame(Computer computer) {
        while (status != Status.GAME_OVER) {
            List<Integer> countBallStrike = new ArrayList<>();
            User user = User.createByNumber(computer.parseList(gameView.printInputMessage()));
            Helper helper = Helper.help(computer, user);
//            status = helper.isThreeStrike()
        }
    }

}
