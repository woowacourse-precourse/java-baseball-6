package baseball.Controller;

import baseball.View.OutputView;
import java.util.List;

public class ComputerController {
    private static final String GAME_HINT_BALL = "볼";
    private static final String GAME_HINT_STRIKE = "스트라이크";
    private static final String GAME_HINT_NOTHING = "낫싱";
    private static final int NUMBERS_LENGTH = 3;
    OutputView outputView = new OutputView();
    private boolean clearCheck;
    private int countStrike;
    private int countBall;

    public boolean clearCheck() {
        return clearCheck;
    }

    public void onClearCheck() {
        clearCheck = false;
    }

    public void makeHint() {
        if (countStrike == NUMBERS_LENGTH) {
            outputView.printHint(countStrike + GAME_HINT_STRIKE);
            outputView.printEndGame();
            clearCheck = true;
        } else if (countBall > 0 || countStrike > 0) {
            outputView.printHint(countBall + GAME_HINT_BALL + " " + countStrike + GAME_HINT_STRIKE);
        } else if (countBall == 0 || countStrike == 0) {
            outputView.printHint(GAME_HINT_NOTHING);
        }
    }

    public void wakeCount() {
        countStrike = 0;
        countBall = 0;
    }

    public void strikeAndBall(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        for (int i = 0; i < NUMBERS_LENGTH; i++) {
            countStrike(computerNumbers.get(i), playerNumbers.get(i));
            countBall(computerNumbers, playerNumbers.get(i), i);
        }
    }

    private void countStrike(int computerNumber, int playerNumber) {
        if (playerNumber == computerNumber) {
            countStrike++;
        }
    }

    private void countBall(List<Integer> computerNumbers, int playerNumber, int index) {
        if (computerNumbers.get(index) != playerNumber && computerNumbers.contains(playerNumber)) {
            countBall++;
        }
    }
}
