package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomBalls {
    public static final int BALLS_COUNT = 3;

    public int getSize() {
        return randomBalls.size();
    }

    private final List<Integer> randomBalls;

    public RandomBalls(List<Integer> randomBalls) {
        this.randomBalls = randomBalls;
    }

    public static RandomBalls makeRandomBalls() { // 랜덤 숫자 생성 기능
        List<Integer> randomBalls = new ArrayList<>();
        while (randomBalls.size() < BALLS_COUNT) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!randomBalls.contains(randomNumber)) {
                randomBalls.add(randomNumber);
            }
        }
        return new RandomBalls(randomBalls);
    }

    public int getBall(int idx) {
        return randomBalls.get(idx);
    }
}
