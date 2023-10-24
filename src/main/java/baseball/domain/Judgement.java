package baseball.domain;

import java.util.List;
import java.util.stream.IntStream;

public class Judgement {

    public Result judgement(List<Integer> opponent, List<Integer> player) {

        int strike = countStrike(opponent, player);
        int ball = countBall(opponent, player);

        return new Result(strike, ball);
    }

    public int countStrike(List<Integer> opponent, List<Integer> player) {
        return (int) IntStream.range(0, 3)
                .filter(i -> opponent.get(i) == player.get(i))
                .count();
    }

    public int countBall(List<Integer> opponent, List<Integer> player) {
        return (int) IntStream.range(0, 3)
                .filter(i -> opponent.contains(player.get(i)))
                .filter(i -> opponent.get(i) != player.get(i))
                .count();
    }
}