package baseball;

import player.Computer;
import player.User;
import referee.Referee;
import score.BaseballScore;

public class Application {

    public static void main(String[] args) {
        Computer computer = new Computer();
        User user = new User();
        BaseballScore score = new BaseballScore();

        Referee referee = new Referee(computer, user, score);
        referee.playBall();
    }
}
