package baseball.model;

import baseball.constant.AttackResult;
import baseball.dto.PlayResult;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static baseball.constant.AttackResult.*;

public class Computer {

    private final List<Ball> balls = new ArrayList<>();

    public Computer() {
        changeBalls();
    }

    public void changeBalls() {
        balls.clear();

        List<Integer> numbers = generateRandomNumbers();

        for (int i = 0; i < numbers.size(); i++) {
            balls.add(new Ball(numbers.get(i), i + 1));
        }
    }

    public PlayResult compareBalls(final List<Ball> playerBalls) {
        Map<AttackResult, Integer> compareResult = initCompareResult();

        for (Ball ball : playerBalls) {
            compareBalls(ball, compareResult);
        }

        return new PlayResult(compareResult.get(STRIKE), compareResult.get(BALL));
    }

    private Map<AttackResult, Integer> initCompareResult() {
        Map<AttackResult, Integer> compareResult = new HashMap<>();
        for (AttackResult attackResult : values()) {
            compareResult.put(attackResult, 0);
        }

        return compareResult;
    }

    private void compareBalls(Ball playerBall, Map<AttackResult, Integer> compareResult) {
        for (Ball ball : this.balls) {
            AttackResult attackResult = ball.checkAttack(playerBall);
            compareResult.put(attackResult, compareResult.get(attackResult) + 1);
        }
    }

    private List<Integer> generateRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }

        return numbers;
    }
}
