package baseball.domain;

import baseball.view.View;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    public static final String RESTART_COMMAND = "1";
    public static final String FINISH_COMMAND = "2";
    public static final int NUMBER_SIZE = 3;

    private List<Integer> targetNumber;
    private boolean isFinish;
    private boolean isGameEnd;

    public void run() {
        View.printGameStartMessage();

        while (!isFinish) {
            isGameEnd = false;
            gameStart();
        }
    }

    public void gameStart() {
        generateTargetNumber();

        while (!isGameEnd) {
            String playerNumber = View.readPlayerNumber();
            GameResult gameResult = new GameResult();
            gameResult.calculate(targetNumber, playerNumber);
            View.printResultMessage(gameResult);
            checkGameOver(gameResult);
        }
    }

    private void generateTargetNumber() {
        List<Integer> targetNumber = new ArrayList<>();
        while (targetNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!targetNumber.contains(randomNumber)) {
                targetNumber.add(randomNumber);
            }
        }
        this.targetNumber = targetNumber;
    }

    private void checkGameOver(GameResult gameResult) {
        if (gameResult.isEnd()) {
            String command = View.readGameEndCommand();

            if (command.equals(FINISH_COMMAND)) {
                isFinish = true;
            }
            isGameEnd = true;
        }
    }
}
