package judge;

import player.Player;
import player.User;
import player.Computer;

public class Judge {

    private Judge() {
    }

    public static Score calculateScore(User user, Computer computer) {
        Score score = new Score();

        for (int userNumber = 0; userNumber < Player.SIZE ; userNumber++) {

            Result compareResult = computer.compare(userNumber, user.getNumber(userNumber));

            if (compareResult == Result.NOTHING) {
                continue;
            }

            if (compareResult == Result.BALL) {
                score.increaseBall();
                continue;
            }

            if (compareResult == Result.STRIKE) {
                score.increaseStrike();
            }
        }

        return score;
    }

}
