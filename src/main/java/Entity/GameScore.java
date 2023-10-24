package Entity;

import static Constants.Constants.NUM_LENGTH;

import java.util.List;

/**
 * 볼 수, 스트라이크 수
 */
public class GameScore {
    private int ball;
    private int strike;

    public GameScore() {
        ball = 0;
        strike = 0;
    }

    public void reset() {
        ball = 0;
        strike = 0;
    }

    public void calculateScore(GameNumber gameNumber) {
        List<Integer> computerNumber = gameNumber.getComputer();
        List<Integer> userNumber = gameNumber.getUser();

        reset();
        for(int i = 0; i < NUM_LENGTH; i++) {
            Integer computerDigit = computerNumber.get(i);
            Integer userDigit = userNumber.get(i);
            if (computerDigit.equals(userDigit)) {  // 같은 수가 같은 자리에 있는 경우
                strike++;
            } else if (computerNumber.contains(userDigit)) {    // 같은 수가 다른 자리에 있는 경우
                ball++;
            }
        }
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }
}
