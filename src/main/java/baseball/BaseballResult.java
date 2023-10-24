package baseball;

public class BaseballResult {
    private int strike = 0;
    private int ball = 0;

    public void addStrike() {
        this.strike += 1;
    }

    public void addBall() {
        this.ball += 1;
    }

    public boolean isSuccess() {
        /* 스트라이크가 3이면 성공 */
        return strike == 3;
    }

    /**
     * @return 볼, 스트라이크의 값을 반환합니다.
     */
    @Override
    public String toString() {
        if ((this.ball != 0) && (this.strike != 0)) {
            return this.ball + "볼 " + this.strike + "스트라이크";
        } else if (this.ball != 0) {
            return this.ball + "볼";
        } else if (this.strike != 0) {
            return this.strike + "스트라이크";
        }
        return "낫싱";
    }
}
