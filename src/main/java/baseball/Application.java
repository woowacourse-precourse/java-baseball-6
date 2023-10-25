package baseball;

import player.Computer;
import player.User;
import referee.Referee;

public class Application {

    public static void main(String[] args) {
        Computer computer = new Computer();
        User user = new User();

        Referee referee = new Referee(computer, user);
        referee.playBall();
    }
}
