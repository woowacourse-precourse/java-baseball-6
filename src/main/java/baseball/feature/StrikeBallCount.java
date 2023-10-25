package baseball.feature;

import java.util.List;
import java.util.stream.IntStream;

public class StrikeBallCount {

    public int countStrike(List<Integer> computer, List<Integer> user) {
        return (int) IntStream.range(0, 3)
                .filter(i -> computer.get(i).equals(user.get(i)))
                .count();
    }

    public int countBall(List<Integer> computer, List<Integer> user) {
        return (int) IntStream.range(0, 3)
                .filter(i -> (!computer.get(i).equals(user.get(i))) && computer.contains(
                        user.get(i)))
                .count();
    }

}
