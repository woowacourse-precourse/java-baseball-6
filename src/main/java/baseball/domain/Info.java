package baseball.domain;

import baseball.view.OutputView;

import java.util.Objects;

public class Info {
    private int ball = 0;
    private int strike = 0;
    private boolean ongoing = true;

    public Info(int ball, int strike, boolean ongoing) {
        this.ball = ball;
        this.strike = strike;
        this.ongoing = ongoing;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }

    public void setStrike(int strike) {
        this.strike = strike;
    }

    public void setOngoing(boolean ongoing) {
        this.ongoing = ongoing;
    }

    public boolean printMsgByUsingInfo() {
        if (ball > 0 && strike > 0) {
            OutputView.printBallAndStrikeMsg(ball, strike); // ?볼 ?스트라이크
        } else if (ball > 0) {
            OutputView.printBallMsg(ball); // ?볼
        } else if (strike > 0) {
            OutputView.printStrikeMsg(strike); // ?스트라이크
        } else if (ball == 0 && strike == 0) {
            OutputView.printNothingMsg(); // 낫싱
        }

        if (strike == 3) {
            ongoing = false;
            OutputView.printSuccessMsg(); // 3개의 숫자를 모두 맞히셨습니다! 게임 종료
            return ongoing;
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Info info = (Info) o;
        return ball == info.ball && strike == info.strike && ongoing == info.ongoing;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ball, strike, ongoing);
    }
}
