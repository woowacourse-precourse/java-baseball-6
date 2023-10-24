package judge;

import player.*;

public class Judge {

    private Judge() {
    }

    public static Score calculateScore(final User user, final Computer computer) {
        Score score = new Score();

        for (int userNumber = 0; userNumber < 3; userNumber++) {

            Result compareResult = computer.compare(userNumber, user.getNumber(userNumber));

            if (compareResult == Result.NOTHING)
                continue;

            if (compareResult == Result.BALL) {
                score.increaseBall();
                continue;
            }

            if (compareResult == Result.STRIKE)
                score.increaseStrike();
        }

        return score;
    }

}
