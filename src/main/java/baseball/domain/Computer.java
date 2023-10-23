package baseball.domain;

import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private String targetNumber;
    private int ballCount;
    private int strikeCount;

    public int gameStart() {
        generateTargetNumber();

        while (true) {
            OutputView.printGameStartMessage();
            String inputNumber = InputView.readUserNumber();
            checkInputNumber(inputNumber);
            OutputView.printResultMessage(ballCount, strikeCount);

            if (strikeCount == 3) {
                return InputView.readGameEndCommand();
            }
        }
    }

    private void generateTargetNumber() {
        StringBuilder targetNumber = new StringBuilder();
        List<Integer> targetNumbers = new ArrayList<>();
        while (targetNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!targetNumbers.contains(randomNumber)) {
                targetNumbers.add(randomNumber);
                targetNumber.append(randomNumber);
            }
        }

        this.targetNumber = targetNumber.toString();
    }

    private void checkInputNumber(String inputNumber) {
        int ballCount = 0;
        int strikeCount = 0;

        for (int i = 0; i < 3; i++) {
            String value = String.valueOf(inputNumber.charAt(i));
            if (!targetNumber.contains(value)) {
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

    private boolean isStrike(String value, int index) {
        int targetIndex = targetNumber.indexOf(value);

        return targetIndex == index;
    }
}
