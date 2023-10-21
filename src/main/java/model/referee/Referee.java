package model.referee;

import model.player.Computer;
import model.player.User;

public class Referee {

    private Referee(User user, Computer computer) {
        this.user = user;
        this.computer = computer;
    }

    private User user;
    private Computer computer;

    public static Referee create(User user, Computer computer) {
        return new Referee(user, computer);
    }

    public GameScoreboard JudgeBaseBallGame() {
        return new GameScoreboard();
    }

    private void userVictory() {

    }

    private void ComputerVictory() {

    }
}
