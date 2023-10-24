package baseball.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class JudgmentService {
    public JudgmentService(){}
    public Integer countStrike(List<Integer> userNumbers, List<Integer> computerNumbers) {
        return (int) IntStream.range(0, 3)
                .filter(i -> isStrike(userNumbers, computerNumbers, i))
                .count();
    }

    public Integer judgeBall(List<Integer> userNumbers, List<Integer> computerNumbers) {
        return (int) IntStream.range(0, 3)
                .filter(i -> !isStrike(userNumbers, computerNumbers, i) && computerNumbers.contains(userNumbers.get(i)))
                .count();
    }

    private boolean isStrike(List<Integer> userNumbers, List<Integer> computerNumbers, int index) {
        return Objects.equals(userNumbers.get(index), computerNumbers.get(index));
    }
}
