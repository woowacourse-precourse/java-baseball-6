package baseball.domain;

public class User {
    private final Balls balls;

    public User(Balls balls) {
        this.balls = balls;
    }

    public Balls getBalls() {
        return balls;
    }
}
