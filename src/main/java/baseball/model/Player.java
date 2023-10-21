package baseball.model;

import baseball.controller.SpanPlayers;

import java.util.List;

public class Player {

    private List<Integer> player;

    public List<Integer> getAttempt() {
        SpanPlayers sp = new SpanPlayers();
        player = sp.playerAttempt();

        return player;
    }

    public List<Integer> getPlayer() {
        return player;
    }

}
