package baseball;

public class ComparisonResult {
    private final int ball;
    private final int strike;

    public ComparisonResult(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    /**
     * 3스트라이크 여부를 확인합니다.
     * @return 3스트라이크 여부
     */
    public boolean isThreeStrike() {
        return strike == 3;
    }

    /**
     * 볼, 스트라이크 개수에 따라 결과 문자열을 만들어줍니다.
     * @return 예시 1: <code>1볼 1스트라이크</code><br>
     *         예시 2: <code>3스트라이크</code><br>
     *         예시 3: <code>낫싱</code>
     */
    @Override
    public String toString() {
        if (ball > 0 && strike > 0) {
            return String.format("%d볼 %d스트라이크", ball, strike);
        }
        else if (ball > 0 && strike == 0) {
            return String.format("%d볼", ball);
        }
        else if (ball == 0 && strike > 0) {
            return String.format("%d스트라이크", strike);
        }
        return "낫싱";
    }
}
