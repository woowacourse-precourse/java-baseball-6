package baseball.Utils;

import baseball.View.OutputView;

public class Checker {
    private int ballCount;
    private int strikeCount;

    public void checkScore(int[] computerNumbers, int[] userNumbers) {
        ballCount = 0;
        strikeCount = 0;

        for (int i = 0; i < 3; i++) {
            compareNumbers(computerNumbers, userNumbers, i);
        }

        OutputView.printResultMessage(ballCount, strikeCount);
    }

    private void compareNumbers(int[] computerNumbers, int[] userNumbers, int index) {
        var temp = -1;

        for (int i = 0; i < computerNumbers.length; i++) {
            if (computerNumbers[i] == userNumbers[index]) {
                temp = i;
                break;
            }
        }

        calculateScore(index, temp);
    }

    private void calculateScore(int index, int temp) {
        if (temp != index && temp != -1) {
            ballCount++;
        }
        if (temp == index) {
            strikeCount++;
        }
    }

    public boolean isThreeStrike() {
        if (strikeCount == 3) {
            return true;
        }

        return false;
    }
}
