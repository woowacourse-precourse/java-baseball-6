package baseball.model.umpire;

import baseball.model.vo.BaseballNumber;
import java.util.List;
import java.util.stream.IntStream;

public class Umpire {

    private int strike;
    private int ball;

    // constructor
    private Umpire() {
        this.strike = 0;
        this.ball = 0;
    }

    // static factory method
    public static Umpire create() {
        return new Umpire();
    }

    // utility
    public void determineStrikeAndBall(BaseballNumber pitcher, BaseballNumber hitter) {
        determineStrike(pitcher, hitter);
        determineBall(pitcher, hitter, strike);
    }

    private void determineStrike(BaseballNumber pitcher, BaseballNumber hitter) {
        List<Integer> pitcherNumber = pitcher.getNumber();
        List<Integer> hitterNumber = hitter.getNumber();

        strike = (int) IntStream.range(0, 3)
                .filter(i -> pitcherNumber.get(i).equals(hitterNumber.get(i)))
                .count();
    }

    private void determineBall(BaseballNumber pitcher, BaseballNumber hitter, int strike) {
        List<Integer> pitcherNumber = pitcher.getNumber();
        List<Integer> hitterNumber = hitter.getNumber();

        ball = (int) IntStream.range(0, 3)
                .filter(i -> pitcherNumber.contains(hitterNumber.get(i)))
                .count()
                - strike;
    }

    public boolean isStrikeOut() {
        return strike == 3;
    }

    // getter
    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
