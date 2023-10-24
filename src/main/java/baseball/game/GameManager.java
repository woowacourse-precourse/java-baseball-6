package baseball.game;

import camp.nextstep.edu.missionutils.Console;
import java.util.Objects;

public class GameManager {
    private int decision;   // TODO: ENUM
    private static final int RESTART_SIGN = 1;
    private static final int END_SIGN = 2;
    private static final String DECISION_GUIDE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static final String INVALID_DECISION_MESSAGE = "해당 입력은 1 또는 2만 가능합니다.";

    public void runGame() {
        do {
            Game game = new Game();
            game.start();
            resolveDecisionInput();
        } while (isPlayerDecisionRestart());
    }

    private boolean isPlayerDecisionRestart() {
        return Objects.equals(this.decision, RESTART_SIGN);
    }

    private void resolveDecisionInput() {
        System.out.println(DECISION_GUIDE);

        String decisionInput = Console.readLine();
        try {
            int decision = Integer.parseInt(decisionInput);
            validateDecisionInput(decision);
            this.decision = decision;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private void validateDecisionInput(int decisionInput) {
        if (!Objects.equals(decisionInput, RESTART_SIGN) && !Objects.equals(decisionInput, END_SIGN)) {
            throw new IllegalArgumentException(INVALID_DECISION_MESSAGE);
        }
    }
}
