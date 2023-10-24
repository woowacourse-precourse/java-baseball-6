package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class ThreeBalls {
    private final Set<Ball> threeBalls = new LinkedHashSet<>();

    public ThreeBalls() {
        initialize();
    }

    public ThreeBalls(int[] inputNumber) {
        initializeFromInputNumber(inputNumber);
    }

    public int equalsCount(ThreeBalls userBalls) {
        int count = 0;
        Iterator<Ball> target = threeBalls.iterator();
        Iterator<Ball> user = userBalls.threeBalls.iterator();

        while (target.hasNext() && user.hasNext()) {
            Ball targetBall = target.next();
            Ball userBall = user.next();

            if (targetBall.equals(userBall)) {
                count++;
            }
        }

        return count;
    }

    public int containCount(ThreeBalls userBalls) {
        return (int) userBalls.threeBalls.stream()
                .filter(threeBalls::contains)
                .count();
    }

    private void initialize() {
        Ball newBall = generateRandomBall();

        for (int i = 0; i < GameConfig.BALLS_SIZE.getValue(); i++) {
            while (isDuplication(newBall)) {
                newBall = generateRandomBall();
            }
        }
    }

    private void initializeFromInputNumber(int[] inputNumber) {
        for (int j : inputNumber) {
            if (isDuplication(new Ball(j))) {
                throw new IllegalArgumentException(GameMessage.WRONG_INPUT.getMessage());
            }
        }
    }

    private boolean isDuplication(Ball newBall) {
        return !threeBalls.add(newBall);
    }


    private Ball generateRandomBall() {
        int randomNumber = Randoms.pickNumberInRange(GameConfig.MIN_NUMBER.getValue(), GameConfig.MAX_NUMBER.getValue());

        return new Ball(randomNumber);
    }
}
