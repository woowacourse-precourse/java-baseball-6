package baseball.model;

import baseball.controller.PlayerAttempt;

import java.util.List;

public class Player {

    private List<Integer> player;

    public List<Integer> getAttempt() {
        PlayerAttempt sp = new PlayerAttempt();
        player = sp.attempt();

        return player;
    }

    public List<Integer> getPlayer() {
        return player;
    }

}
