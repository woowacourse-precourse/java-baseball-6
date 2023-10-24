package baseball.game;

import camp.nextstep.edu.missionutils.Console;
import java.util.Objects;

public class GameManager {
    public void runGame() {
        do {
            Game game = new Game();
            game.start();
        } while (isPlayerDecisionResume());
    }

    private boolean isPlayerDecisionResume() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String decisionInput = Console.readLine();
        validateDecision(decisionInput);
        return decisionInput.equals("1");
    }

    private void validateDecision(String decision) {    // TODO: String -> int
        if (!Objects.equals(decision, "1") && !Objects.equals(decision, "2")) {
            throw new IllegalArgumentException("해당 입력은 1 또는 2만 가능합니다.");
        }
    }
}
