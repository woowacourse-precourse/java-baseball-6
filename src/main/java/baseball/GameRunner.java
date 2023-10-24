package baseball;

import static baseball.domain.GameRules.*;
import static baseball.ui.GameOutputView.*;

import baseball.domain.RandomNumberGenerator;
import baseball.ui.GameInputView;
import java.util.List;

public class GameRunner {
    List<Integer> computerNumber;

    GameRunner() {
        this.computerNumber = RandomNumberGenerator.generate();
    }

    void runGameLoop() {
        boolean userWin = false;
        while (!userWin) {
            userWin = playGame();
        }
    }

    private boolean playGame() {
        showNumberInputMessage();
        List<Integer> userNumber = GameInputView.userNumberInput();

        int strike = countStrike(userNumber, computerNumber);
        int ball = countBall(userNumber, computerNumber) - strike;

        printLoopResult(ball, strike);

        if (isUserWin(strike)) {
            showWinMessage();
            return true;
        }
        return false;
    }
}
