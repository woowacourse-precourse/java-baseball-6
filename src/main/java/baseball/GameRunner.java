package baseball;

import static baseball.domain.GameRules.*;
import static baseball.ui.GameOutput.printLoopResult;
import static baseball.ui.GameOutput.showWinMessage;

import baseball.domain.RandomNumberGenerator;
import baseball.ui.GameInput;
import java.util.List;

public class GameRunner {
    List<Integer> computerNumber;

    GameRunner() {
        this.computerNumber = RandomNumberGenerator.generate();
    }

    void runGameLoop() {
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
