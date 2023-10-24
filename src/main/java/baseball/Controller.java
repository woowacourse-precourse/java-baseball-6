package baseball;

import static baseball.utils.Constants.PROGRAM_EXIT;
import static baseball.utils.Constants.RESTART_GAME;
import static baseball.utils.GameMessage.RESTART_REQUEST_MESSAGE;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Controller {
    public Controller() {
    }

    public void startGame() {
        Computer computer = new Computer();
        Player player = new Player();
        String status;

        do {
            player.init();
            player.play();
            printRestartRequestMessage();
            status = readLine();
            validateRestartRange(status);
        } while (RESTART_GAME.equals(status));
    }

    private void printRestartRequestMessage() {
        System.out.println(RESTART_REQUEST_MESSAGE);
    }

    private void validateRestartRange(String status) {
        if (!status.equals(RESTART_GAME) && !status.equals(PROGRAM_EXIT)) {
            throw new IllegalArgumentException("입력이 1 또는 2가 아닙니다.");
        }
    }
}
