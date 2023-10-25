package baseball.domain;

import static baseball.utils.AppConstants.GAME_END_NUMBER;
import static baseball.utils.AppConstants.GAME_RESTART_NUMBER;

import baseball.utils.MessagePrinter;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Player {
    private final GameManager gameManager;

    public Player(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    public void playGame() {
        List<Integer> computerNumbers = Computer.generateRandomNumber();
        MessagePrinter.printGameStartMessage();
        String playerNumbers;
        do {
            MessagePrinter.printRequestPlayerInputMessage();
            playerNumbers = Console.readLine();
            gameManager.validPlayerNumbers(playerNumbers);
        } while (gameManager.compareNumbers(computerNumbers, playerNumbers));
    }

    public boolean restartGame() {
        MessagePrinter.printRestartGameMessage();
        String playerDecision = Console.readLine();
        if (playerDecision.equals(GAME_RESTART_NUMBER)) {
            return true;
        }
        if (playerDecision.equals(GAME_END_NUMBER)) {
            return false;
        }
        throw new IllegalArgumentException("입력은 " + GAME_RESTART_NUMBER + " 또는 " + GAME_END_NUMBER + "이어야 합니다.");
    }
}