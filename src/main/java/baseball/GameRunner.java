package baseball;

import static baseball.domain.GameRules.*;
import static baseball.ui.GameOutput.*;

import baseball.domain.RandomNumberGenerator;
import baseball.ui.GameInput;
import java.util.List;

public class GameRunner {
    List<Integer> computerNumber;

    public void start() {
        showStartMessage();
        boolean gameContinuation = true;
        while (gameContinuation) {
            computerNumber = RandomNumberGenerator.generate();
            runGameLoop();
            gameContinuation = GameInput.getContinueInput();
        }
    }

    private void runGameLoop() {
        boolean userWin = false;
        while (!userWin) {
            List<Integer> userNumber = GameInput.userNumberInput();
            int strike = countStrike(userNumber, computerNumber);
            int ball = countBall(userNumber, computerNumber) - strike;
            printLoopResult(ball, strike);
            if (isUserWin(strike)) {
                showWinMessage();
                userWin = true;
            }
        }
    }
}
