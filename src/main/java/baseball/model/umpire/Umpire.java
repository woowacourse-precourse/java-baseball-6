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
    public List<Integer> determineStrikeAndBall(BaseballNumber pitcher, BaseballNumber hitter) {
        int strike = determineStrike(pitcher, hitter);
        int ball = determineBall(pitcher, hitter, strike);

        return List.of(strike, ball);
    }

    private int determineStrike(BaseballNumber pitcher, BaseballNumber hitter) {
        List<Integer> pitcherNumber = pitcher.getNumber();
        List<Integer> hitterNumber = hitter.getNumber();

        strike = (int) IntStream.range(0, 3)
                .filter(i -> pitcherNumber.get(i).equals(hitterNumber.get(i)))
                .count();

        return strike;
    }

    private int determineBall(BaseballNumber pitcher, BaseballNumber hitter, int strike) {
        List<Integer> pitcherNumber = pitcher.getNumber();
        List<Integer> hitterNumber = hitter.getNumber();

        ball = (int) IntStream.range(0, 3)
                .filter(i -> pitcherNumber.contains(hitterNumber.get(i)))
                .count();
        ball -= strike;

        return ball;
    }

    public boolean isStrikeOut() {
        return strike == 3;
    }

}
