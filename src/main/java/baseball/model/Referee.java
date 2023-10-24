package baseball.model;

import java.util.List;

public class Referee {
    private int strike;
    private int ball;

    public Referee() {
        initReferee();
    }

    public void initReferee() {
        strike = 0;
        ball = 0;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public void countBallAndStrike(List<Integer> computerNum, String userNum) {
        for(int i = 0; i < 3; i++) {
            int userIntNum = userNum.charAt(i)-'0';
            if(computerNum.get(i) == userIntNum) {
                strike++;
                continue;
            }
            if(computerNum.contains(userIntNum)) {
                ball++;
            }
        }
    }

    public boolean isThreeStrike() {
        return strike == 3;
    }
}
