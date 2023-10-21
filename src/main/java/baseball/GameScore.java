package baseball;

import java.util.List;
import java.util.Objects;

public class GameScore {
    private final List<Integer> suggestion;
    private final List<Integer> computer;

    public GameScore(List<Integer> suggestion, List<Integer> computer) {
        this.suggestion = suggestion;
        this.computer = computer;
    }

    public int getStrike() {
        int strike = 0;
        for (int i = 0; i < 3; i++) {
            if (Objects.equals(suggestion.get(i), computer.get(i))) {
                strike++;
            }
        }
        return strike;
    }

    public int getBall() {
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            if (computer.contains(suggestion.get(i)) && !Objects.equals(suggestion.get(i), computer.get(i))) {
                ball++;
            }
        }
        return ball;
    }
}
