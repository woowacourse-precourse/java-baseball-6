package baseball;

import static baseball.utils.Constants.PROGRAM_EXIT;
import static baseball.utils.Constants.RESTART_GAME;
import static baseball.utils.ErrorMessage.STATUS_OUT_OF_RANGE_ERROR_MESSAGE;
import static baseball.utils.GameMessage.ASK_RESTART_OR_EXIT_REQUEST_MESSAGE;
import static baseball.utils.GameMessage.START_GAME_MESSAGE;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Controller {
    public Controller() {
    }

    public void startGame() {
        Player player = new Player();
        String status;
        printStartGameMessage();
        do {
            player.init();
            player.play();
            printAskRestartOrExitMessage();
            status = readLine();
            validateStatusRange(status);
        } while (RESTART_GAME.equals(status));
    }

    private void printStartGameMessage() {
        System.out.println(START_GAME_MESSAGE);
    }

    private void printAskRestartOrExitMessage() {
        System.out.println(ASK_RESTART_OR_EXIT_REQUEST_MESSAGE);
    }

    private void validateStatusRange(String status) {
        if (!status.equals(RESTART_GAME) && !status.equals(PROGRAM_EXIT)) {
            throw new IllegalArgumentException(STATUS_OUT_OF_RANGE_ERROR_MESSAGE);
        }
    }
}
