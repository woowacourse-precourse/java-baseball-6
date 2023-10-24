package baseball;

import java.util.List;

public class Ball {

    private List<Integer> randomBalls;
    private int size;
    private final int ASCII_NUM = 48;

    public Ball(List<Integer> randomBalls) {
        this.randomBalls = randomBalls;
    }

    public Hint makeHint(String userBalls) {
        char[] usrBallsTemp = userBalls.toCharArray();
        int ball = 0;
        int strike = 0;
        int userIndex = 0;

        for (char userBall : usrBallsTemp) {
            int randomIndex = randomBalls.indexOf(userBall - ASCII_NUM);
            if (userIndex == randomIndex) {
                strike++;
            } else if (randomIndex >= 0) {
                ball++;
            }
            userIndex++;
        }
        return new Hint(ball, strike);
    }
}
