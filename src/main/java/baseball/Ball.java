package baseball;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;
import camp.nextstep.edu.missionutils.Randoms;

public class Ball {
    private final static int BALL_LENGTH = 3;
    private int[] ballNumber = new int[BALL_LENGTH];

    public Ball() {
        Set<Integer> intHashSet = new HashSet<>();
        while (intHashSet.size() < BALL_LENGTH) {
            intHashSet.add(Randoms.pickNumberInRange(1,9));
        }
        int index = 0;
        for (int i : intHashSet) {
            ballNumber[index++] = i;
        }
    }

    public Ball(int number) {
        if ((int) (Math.log10(number) + 1) > BALL_LENGTH) {
            throw new IllegalArgumentException();
        }

        this.ballNumber = Stream.of(String.valueOf(number)
                .split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public BallResult compareWith(Ball ball) {

        int b = 0;
        int s = 0;

        for(int i = 0; i < BALL_LENGTH; i++) {
            if(ball.ballNumber[i] == this.ballNumber[i]){
                s += 1;
            }
            for(int j = 0; j < BALL_LENGTH; j++) {
                if (j == i) {
                    continue;
                }
                if (ball.ballNumber[i] == this.ballNumber[j]) {
                    b += 1;
                }
            }
        }

        return new BallResult(b,s);
    }
}
