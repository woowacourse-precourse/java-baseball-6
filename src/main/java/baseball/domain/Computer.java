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
    private int ballCount;
    private int strikeCount;
    private boolean isFinish;

    public void run() {
        View.printGameStartMessage();

        while (!isFinish) {
            gameStart();
        }
    }

    public void gameStart() {
        initializeGameSetting();
        generateTargetNumber();

        while (isGameContinue()) {
            String playerNumber = View.readPlayerNumber();
            calculateResult(playerNumber);
            View.printResultMessage(ballCount, strikeCount);
        }
    }

    private void initializeGameSetting() {
        ballCount = 0;
        strikeCount = 0;
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

    private boolean isGameContinue() {
        if (strikeCount == 3) {
            String command = View.readGameEndCommand();

            if (command.equals(FINISH_COMMAND)) {
                isFinish = true;
            }
            return false;
        }

        return true;
    }

    private void calculateResult(String playerNumber) {
        int ballCount = 0;
        int strikeCount = 0;

        for (int i = 0; i < 3; i++) {
            int value = Integer.parseInt(playerNumber.substring(i, i + 1));
            if (isNothing(value)) {
                continue;
            }
            if (isStrike(value, i)) {
                strikeCount++;
                continue;
            }
            ballCount++;
        }

        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    private boolean isNothing(int value) {
        return !targetNumber.contains(value);
    }

    private boolean isStrike(int value, int index) {
        int indexInTargetNumber = targetNumber.indexOf(value);

        return indexInTargetNumber == index;
    }
}
