package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class SelectedBalls {
    private final Queue<Integer> balls = new LinkedList<>();


    public SelectedBalls(){
        initBalls();
    }

    private void initBalls() {
        while (balls.size() < 3) {
            int ball = Randoms.pickNumberInRange(1, 9);
            if (balls.contains(ball)) {
                continue;
            }
            balls.add(ball);
        }
    }

    public String getBalls() {
        return balls.stream()
                .map(Object::toString)
                .collect(Collectors.joining());
    }
}
