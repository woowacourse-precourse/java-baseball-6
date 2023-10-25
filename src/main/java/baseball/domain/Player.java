package baseball.domain;

import java.util.List;

public class Player {
    List<Integer> playerBall;

    public List<Integer> getPlayerBall() {
        return playerBall;
    }

    public void createPlayerBall(List<Integer> playerBall) {
        this.playerBall = playerBall;
    }
}
