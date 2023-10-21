package baseball.domain.player;

import baseball.domain.result.GameResult;

public class Computer extends Playable {

    public Computer() {
        super();
    }

    public GameResult compareWithPlayer(Player player) {
        return this.balls.compareWithBalls(player.balls);
    }
}