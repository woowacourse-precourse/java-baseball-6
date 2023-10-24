package baseball.model;

import static baseball.util.AppConstants.BALLS_SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ComputerBalls {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    private final List<Ball> computerBalls;

    public ComputerBalls() {
        this.computerBalls = generateComputerBalls();
    }

    public List<Ball> getComputerBalls() {
        return this.computerBalls;
    }

    public List<Ball> generateComputerBalls() {
        Set<Integer> candidates = new HashSet<>();
        while (candidates.size() < BALLS_SIZE) {
            candidates.add(Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER));
        }
        return candidates.stream()
                .map(Ball::new)
                .collect(java.util.stream.Collectors.toList());
    }
}