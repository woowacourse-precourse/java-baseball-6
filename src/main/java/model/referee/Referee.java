package model.referee;

import model.player.Player;

public class Referee {

    private Referee(Player user, Player computer) {
        this.user = user;
        this.computer = computer;
    }

    private Player user;
    private Player computer;

    public static Referee create(Player user, Player computer) {
        return new Referee(user, computer);
    }

    public boolean JudgeBaseBallGame() {
        return false;
    }

    private void userVictory() {

    }

    private void ComputerVictory() {
        
    }
}
