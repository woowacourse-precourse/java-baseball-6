package baseball;

import static baseball.domain.GameRules.*;
import static baseball.ui.GameOutput.*;

import baseball.domain.RandomNumberGenerator;
import baseball.ui.GameInput;
import java.util.List;

public class GameRunner {
    public void start() {
        showStartMessage();

        boolean gameContinue = true;
        while (gameContinue) {
            List<Integer> computerNumber = RandomNumberGenerator.generate();
            runGameLoop(computerNumber);
            gameContinue = GameInput.getContinueInput();
        }
    }

    private void runGameLoop(List<Integer> computerNumber) {
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
