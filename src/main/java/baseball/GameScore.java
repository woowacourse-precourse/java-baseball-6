package baseball;

import java.util.List;
import java.util.Objects;

public class GameScore {
    private final List<Integer> user;
    private final List<Integer> computer;

    public GameScore(List<Integer> user, List<Integer> computer) {
        this.user = user;
        this.computer = computer;
    }

    public int calculateStrike() {
        int strike = 0;
        for (int i = 0; i < 3; i++) {
            if (Objects.equals(user.get(i), computer.get(i))) {
                strike++;
            }
        }
        return strike;
    }

    public int calculateBall() {
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            if (computer.contains(user.get(i)) && !Objects.equals(user.get(i), computer.get(i))) {
                ball++;
            }
        }
        return ball;
    }
}