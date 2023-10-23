/*
 * <pre>
 * Class : ResultBall
 * Comment: 스트라이크와 볼 수를 저장
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2023-10-23       손준형           최초 생성
 * </pre>
 *
 * @author 손준형
 * @version 1.0.0
 * @see
 */

package vo;

public class ResultBall {

    private final int strike;
    private final int ball;

    public ResultBall(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
