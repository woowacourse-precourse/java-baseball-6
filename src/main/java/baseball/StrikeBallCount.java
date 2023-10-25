package baseball;

public class StrikeBallCount {
    private int strike;
    private int ball;

    public void settingStrikeBallCount() {
        strike = 0;
        ball = 0;
    }

    public void plusStrikeCount() {
        strike++;
    }

    public void plusBallCount() {
        ball++;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
