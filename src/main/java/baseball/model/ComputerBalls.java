package baseball.model;

import static baseball.util.AppConstants.BALLS_SIZE;
import static baseball.util.AppConstants.INT_MAX_NUMBER;
import static baseball.util.AppConstants.INT_MIN_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ComputerBalls {

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
            candidates.add(Randoms.pickNumberInRange(INT_MIN_NUMBER, INT_MAX_NUMBER));
        }
        return candidates.stream()
                .map(Ball::new)
                .collect(java.util.stream.Collectors.toList());
    }
}