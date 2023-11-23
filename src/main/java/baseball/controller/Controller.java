package baseball.controller;

import static baseball.utils.Constants.PROGRAM_EXIT;
import static baseball.utils.Constants.RESTART_GAME;
import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.domain.Player;
import baseball.utils.GameMessage;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Controller {
    public Controller() {
    }

    public void startGame() {
        Player player = new Player();
        String status;
        OutputView.printMessage(GameMessage.START_GAME_MESSAGE.getMessage());
        do {
            player.init();
            player.play();
            OutputView.printAskRestartOrExitMessage();
            status = InputView.askRestart();
            validateStatusRange(status);
        } while (RESTART_GAME.equals(status));
    }

    private void validateStatusRange(String status) {
        if (!status.equals(RESTART_GAME) && !status.equals(PROGRAM_EXIT)) {
            throw new IllegalArgumentException();
        }
    }
}
