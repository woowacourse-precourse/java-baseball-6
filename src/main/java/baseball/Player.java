package baseball;

import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class Player {
    private static final String GAME_RESTART_NUMBER = "1";
    private static final String GAME_END_NUMBER = "2";

    private final GameManager gameManager;

    public Player(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    public void playGame() {
        List<Integer> computerNumbers = Computer.generateRandomNumber();
        System.out.println("숫자 야구 게임을 시작합니다.");
        String playerNumbers;
        do {
            System.out.print("숫자를 입력해주세요 : ");
            playerNumbers = Console.readLine();
            gameManager.validPlayerNumbers(playerNumbers);
        } while (gameManager.compareNumbers(computerNumbers, playerNumbers));
    }

    public boolean restartGame() {
        System.out.println("게임을 새로 시작하려면 " + GAME_RESTART_NUMBER + ", 종료하려면 " + GAME_END_NUMBER + "를 입력하세요.");
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