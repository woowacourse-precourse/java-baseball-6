package baseball.game;

import camp.nextstep.edu.missionutils.Console;
import java.util.Objects;

/**
 * GameManager 게임의 시작, 재시작, 종료를 전반적으로 관리하는 객체
 */
public class GameManager {
    private PlayerDecision playerDecision;

    public void runGame() {
        do {
            Game game = new Game();
            game.start();

            setPlayerDecision(resolvePlayerDecisionFromInput());
        } while (isPlayerDecisionRestart());
    }

    private void setPlayerDecision(PlayerDecision playerDecision) {
        this.playerDecision = playerDecision;
    }

    private PlayerDecision resolvePlayerDecisionFromInput() {
        System.out.println(PlayerDecision.DECISION_GUIDE);

        String decisionInput = Console.readLine();
        try {
            int decisionValue = Integer.parseInt(decisionInput);
            return PlayerDecision.of(decisionValue);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private boolean isPlayerDecisionRestart() {
        return Objects.equals(this.playerDecision, PlayerDecision.RESTART);
    }
}
