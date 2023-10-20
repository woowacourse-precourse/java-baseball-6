package baseball;

import java.util.ListIterator;

public class BaseBallResult {
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
    }
}
