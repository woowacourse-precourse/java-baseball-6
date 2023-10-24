package baseball.domain;

import baseball.controller.GameController;
import baseball.utils.OutputMessage;
import java.util.List;

public class NumberBaseballGame {
    private final Player player;
    private final Computer computer;

    public NumberBaseballGame(Player player, Computer computer) {
        this.player = player;
        this.computer = computer;
    }

    public void gameStart() {
        gameSetting();
        game();
    }

    private void game() {
        List<Integer> playerInput = player.getPlayerInput();
        String resultMessage = computer.getResult(playerInput);
        printResult(resultMessage);
        handleGame(isFinish(resultMessage));
    }

    private void printResult(String resultMessage) {
        OutputMessage.printResult(resultMessage);
    }

    private void gameSetting() {
        computer.setAnswer();
    }

    private boolean isFinish(String resultMessage) {
        if ("3스트라이크".equals(resultMessage)) {
            OutputMessage.successMessage();
            return true;
        }
        return false;
    }

    private void handleGame(boolean tag) {
        if (tag) {
            String restart = player.getRestartMessage();
            GameController.restartGame(restart);
        } else {
            game();
        }
    }


}
