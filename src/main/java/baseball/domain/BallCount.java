package baseball.domain;

import baseball.utils.Setting;

public class BallCount {

    private int ball;
    private int strike;

    public BallCount() {
        this.ball = 0;
        this.strike = 0;
    }

    public void setBallCount(int ball, int strike) {  // 볼카운트 세팅 메서드
        this.ball = ball;
        this.strike = strike;

        printBallCount(ball, strike);
    }

    public void printBallCount(int ball, int strike) {  // 볼카운트 출력 메서드
        if (strike == Setting.NUM_LENGTH)
            System.out.println(correctAnswer());
        else if (ball == 0 && strike == 0)
            System.out.println(getNothing());
        else if (strike == 0)
            System.out.println(getOnlyBall());
        else if (ball == 0)
            System.out.println(getOnlyStrike());
        else
            System.out.println(getBallCount());
    }

    public String getBallCount() { return ball + "볼 " + strike + "스트라이크"; }
    public String getOnlyBall() { return ball + "볼"; }
    public String getOnlyStrike() { return strike + "스트라이크"; }
    public String getNothing() { return "낫싱"; }
    public String correctAnswer() { return strike + "스트라이크 \n" + strike + "개의 숫자를 모두 맞히셨습니다! 게임 종료"; }
}
