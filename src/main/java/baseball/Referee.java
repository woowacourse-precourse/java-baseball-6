package baseball;

import java.util.List;
import java.util.stream.Stream;

public class Referee {
    public RoundResult judge(List<Integer> catcher, List<Integer> pitcher) {
        int strike = countStrike(catcher, pitcher);
        int ball = countBall(catcher, pitcher);

        return new RoundResult(strike, ball);
    }

    public int countStrike(List<Integer> catcher, List<Integer> pitcher) {
        return (int) Stream.iterate(0, i -> i + 1).limit(Constant.MAX_NUMBER_SIZE)
                .filter(i -> catcher.get(i).equals(pitcher.get(i)))
                .count();
    }

    public int countBall(List<Integer> catcher, List<Integer> pitcher) {
        return (int) Stream.iterate(0, i -> i + 1).limit(Constant.MAX_NUMBER_SIZE)
                .filter(i -> !catcher.get(i).equals(pitcher.get(i)) && catcher.contains(pitcher.get(i)))
                .count();
    }
}
