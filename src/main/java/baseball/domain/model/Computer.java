package baseball.domain.model;

import java.util.List;

public class Computer {
    private final List<String> computer;

    public Computer(final List<String> computer) {
        this.computer = computer;
    }

    public BallCount compareWithUserBall(final String userBall, final int userBallIndex) {
        if (this.computer.indexOf(userBall) == userBallIndex) {
            return BallCount.STRIKE;
        }
        if (this.computer.contains(userBall)) {
            return BallCount.BALL;
        }
        return BallCount.OUT;
    }
}
