package baseball;

import java.util.Arrays;
import java.util.List;

public class Ball {

    private List<Integer> randomBalls;
    private int size;

    public Ball(List<Integer> randomBalls) {
        this.randomBalls = randomBalls;
    }

    public Hint makeHint(String userBalls) {
        int[] usrBallsTemp = Arrays.stream(userBalls.split("")).mapToInt(Integer::parseInt).toArray();
        int ball = 0;
        int strike = 0;
        int userIndex = 0;

        for (int userBall : usrBallsTemp) {
            int randomIndex = randomBalls.indexOf(userBall);

            if (userIndex == randomIndex) {
                strike++;
            } else if (randomIndex > 0) {
                ball++;
            }
            userIndex++;
        }
        return new Hint(ball, strike);
    }
}
