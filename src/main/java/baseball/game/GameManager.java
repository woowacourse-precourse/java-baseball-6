package baseball.game;

import camp.nextstep.edu.missionutils.Console;

/**
 * GameManager 게임의 시작, 재시작, 종료를 전반적으로 관리하는 객체
 */
public class GameManager {
    private PlayerDecision playerDecision;

    public void manage() {
        do {
            BaseballGame baseballGame = new BaseballGame();
            baseballGame.run();

            resolvePlayerDecisionFromInput();
        } while (playerDecision.isKeepPlaying());
    }

    private void resolvePlayerDecisionFromInput() {
        System.out.println(PlayerDecision.DECISION_GUIDE);

        String decisionInput = Console.readLine();
        try {
            int decisionValue = Integer.parseInt(decisionInput);
            this.playerDecision = PlayerDecision.of(decisionValue);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

}
