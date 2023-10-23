package judge;

import player.*;

public class Judge {

    private Judge() {
    }

    public static Score calculateScore(User user, Computer computer) {
        Score score = new Score();

        for (int userNumber = 0; userNumber < 3; userNumber++) {

            int compareResult = computer.compare(userNumber, user.getNumber(userNumber));

            if (compareResult == 0)
                continue;

            if (compareResult == 1) {
                score.increaseBall();
                continue;
            }

            if (compareResult == 2)
                score.increaseStrike();
        }

        return score;
    }

}
