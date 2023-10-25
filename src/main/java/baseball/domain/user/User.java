package baseball.domain.user;

import baseball.domain.ball.Balls;
import baseball.domain.computer.Computer;
import baseball.domain.result.Result;

public class User {
    private final Balls balls;

    public User(Balls balls) {
        this.balls = balls;
    }

    public Result compare(Computer computer) {
        return computer.compare(this.balls);
    }
}