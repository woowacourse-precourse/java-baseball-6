package baseball.domain.player;

import baseball.domain.ball.Balls;

public abstract class Playable {
    protected final Balls balls;

    public Playable(int number) {
        this.balls = new Balls(number);
    }

    public Playable() {
        this.balls = new Balls();
    }
}