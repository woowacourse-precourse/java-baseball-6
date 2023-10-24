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

    public void run() {
        boolean isGameEnd = false;
        while (!isGameEnd) {
            int command = gameStart();

            if (command == END) {
                isGameEnd = true;
            }
        }
    }

    public int gameStart() {
        generateTargetNumber();

        while (true) {
            View.printGameStartMessage();
            String inputNumber = View.readUserNumber();
            checkInputNumber(inputNumber);
            View.printResultMessage(ballCount, strikeCount);

            if (strikeCount == 3) {
                return View.readGameEndCommand();
            }
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

    }

    private void checkInputNumber(String inputNumber) {
        int ballCount = 0;
        int strikeCount = 0;

        for (int i = 0; i < 3; i++) {
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
