package baseball;

import java.util.ListIterator;

public class BaseBallResult {
    private final String STRING_BALL_PREFIX = "볼";
    private final String STRING_STRIKE_PREFIX = "스트라이크";
    private final String STRING_SPLIT = " ";
    private final String STRING_NOTHING = "낫싱";

    private int ball = 0;
    private int strike = 0;

    public BaseBallResult(BaseBallNumberGroup answer, BaseBallNumberGroup user) {
        getBallAndStrike(answer, user);
    }

    private void getBallAndStrike(BaseBallNumberGroup answer, BaseBallNumberGroup user) {
        ListIterator<Integer> answerIterator = answer.iterator();
        while (answerIterator.hasNext()) {
            int answerNumber = answerIterator.next();
            int answerIndex = answerIterator.nextIndex();

            ListIterator<Integer> userIterator = user.iterator();
            while (userIterator.hasNext()) {
                int userNumber = userIterator.next();
                int userIndex = userIterator.nextIndex();

                increaseBallWhenSameNumberAndDifferentIndex(answerNumber, answerIndex, userNumber, userIndex);
                increaseStrikeWhenSameNumberAndSameIndex(answerNumber, answerIndex, userNumber, userIndex);
            }
        }
    }

    private void increaseBallWhenSameNumberAndDifferentIndex(
            int answerNumber,
            int answerIndex,
            int userNumber,
            int userIndex
    ) {
        if (answerNumber != userNumber) {
            return;
        }

        if (answerIndex != userIndex) {
            ball++;
        }
    }

    private void increaseStrikeWhenSameNumberAndSameIndex(
            int answerNumber,
            int answerIndex,
            int userNumber,
            int userIndex
    ) {
        if (answerNumber != userNumber) {
            return;
        }

        if (answerIndex == userIndex) {
            strike++;
        }
    }

    public void print() {
        printBallWhenBallExist();
        printSplitWhenBallAndStrikeExist();
        printStrikeWhenStrikeExist();
        printNothingWhenBothBallAndStrikeNotExist();
        printNewLine();
    }

    private void printBallWhenBallExist() {
        if (ball > 0) {
            System.out.print(ball + STRING_BALL_PREFIX);
        }
    }

    private void printSplitWhenBallAndStrikeExist() {
        if (ball > 0 && strike > 0) {
            System.out.print(STRING_SPLIT);
        }
    }

    private void printStrikeWhenStrikeExist() {
        if (strike > 0) {
            System.out.print(strike + STRING_STRIKE_PREFIX);
        }
    }

    private void printNothingWhenBothBallAndStrikeNotExist() {
        if (ball == 0 && strike == 0) {
            System.out.print(STRING_NOTHING);
        }
    }

    private void printNewLine() {
        System.out.println();
    }

    public boolean isAllStrike() {
        return strike == GameConstants.SIZE_RANDOM_NUMBER;
    }
}
