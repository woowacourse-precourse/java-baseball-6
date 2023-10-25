package baseball.game;

import baseball.game.model.Computer;
import baseball.game.model.RestartState;
import baseball.game.model.Result;
import baseball.game.model.User;

public class Controller {
    private View view;
    private Computer computer;

    public void init() {
        view.printStartMessage();
        playGame();
    }

    public void playGame() {
        computer = computer.of();
        playRound();
        view.printEnd();
        restart(view.askRestart());
    }

    public void playRound() {
        User user = User.of(view.inputNumber());
        Result result = computer.compareToUser(user);
        view.printResult(result);
        if (result.isThreeStrike()) {
            return;
        }
        playRound();
    }

    public void restart(String restartRequest) {
        RestartState restartState = RestartState.of(restartRequest);
        if (restartState.isRestart() == true) {
            playGame();
        }
    }

    public Controller(View view) {
        this.view = view;
    }
}
