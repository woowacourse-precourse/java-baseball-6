package baseball.model;

import baseball.constant.AttackResult;

import static baseball.constant.AttackResult.*;

public class Ball {
    private final int value;
    private final int position;

    public Ball(int value, int position) {
        this.value = value;
        this.position = position;
    }

    public AttackResult checkAttack(Ball ball) {
        if (this.value != ball.getValue()) {
            return NOTHING;
        }

        if (this.position == ball.getPosition()) {
            return STRIKE;
        }

        return BALL;
    }

    public int getValue() {
        return value;
    }

    public int getPosition() {
        return position;
    }
}
