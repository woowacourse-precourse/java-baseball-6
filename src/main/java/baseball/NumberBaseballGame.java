package baseball;

import static baseball.constant.GameConstants.MAX_NUMBER_LENGTH;
import static baseball.view.GameOutput.*;

import baseball.view.GameInput;
import java.util.List;

public class NumberBaseballGame {
    List<Integer> computerNumber;
    private final RandomNumberGenerator randomNumberGenerator;
    private final GameInput gameInput;

    NumberBaseballGame() {
        this.randomNumberGenerator = new RandomNumberGenerator();
        this.gameInput = new GameInput();
    }

    public void start() {
        showStartMessage();
        boolean gameContinuation = true;
        while (gameContinuation) {
            computerNumber = randomNumberGenerator.generate();
            runGameLoop();
            gameContinuation = gameInput.getContinueInput();
        }
    }

    private void runGameLoop() {
        boolean userWin = false;
        while (!userWin) {
            List<Integer> userNumber = gameInput.userNumberInput();
            int strike = countStrike(userNumber, computerNumber);
            int ball = countBall(userNumber, computerNumber) - strike;
            printLoopResult(ball, strike);
            if (isUserWin(strike)) {
                showWinMessage();
                userWin = true;
            }
        }
    }

    boolean isUserWin(int strike) {
        return strike == MAX_NUMBER_LENGTH;
    }

    int countBall(List<Integer> userNumber, List<Integer> computerNumber) {
        int ball = 0;
        for (int i = 0; i < MAX_NUMBER_LENGTH; i++) {
            if (computerNumber.contains(userNumber.get(i))) {
                ball++;
            }
        }
        return ball;
    }

    int countStrike(List<Integer> userNumber, List<Integer> computerNumber) {
        int strike = 0;
        for (int i = 0; i < MAX_NUMBER_LENGTH; i++) {
            if (computerNumber.get(i).equals(userNumber.get(i))) {
                strike++;
            }
        }
        return strike;
    }
}
