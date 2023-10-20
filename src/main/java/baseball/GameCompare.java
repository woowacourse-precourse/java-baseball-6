package baseball;

import java.util.List;
import java.util.stream.IntStream;

public class GameCompare {
    private int ball;
    private int strike;

    public GameCompare() {
        this.ball = 0;
        this.strike = 0;
    }

    public void compareStrike(List<Integer> randomNum, List<Integer> inputNum) {
        List<Integer> strike = IntStream.range(0, 3)
                .filter(i -> randomNum.get(i).equals(inputNum.get(i)))
                .mapToObj(randomNum::get).toList();
        this.strike = strike.size();
    }

    public void compareBall(List<Integer> randomNum, List<Integer> inputNum) {
        List<Integer> ball = randomNum.stream()
                .filter(inputNum::contains).toList();
        this.ball = ball.size();
    }

    public int getball() {
        return ball;
    }

    public int getstrike() {
        return strike;
    }
}
