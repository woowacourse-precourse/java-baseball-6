package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

    }

    /**
     * 랜덤 볼 3개 만들기
     */
    private List<Integer> makeRandomBalls() {
        List<Integer> randomBalls = new ArrayList<>();

        while (randomBalls.size() < 3) {
            int randomBall = Randoms.pickNumberInRange(1, 9);
            if (!randomBalls.contains(randomBall)) {
                randomBalls.add(randomBall);
            }
        }

        return randomBalls;
    }


}
