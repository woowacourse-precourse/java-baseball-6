/*
 * <pre>
 * Class : ResultView
 * Comment: 사용자 입력과 난수를 비교한 결과 출력
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2023-10-22       손준형           최초 생성
 * 2023-10-23       손준형           매직넘버 상수 대체
 * </pre>
 *
 * @author 손준형
 * @version 1.0.0
 * @see
 */

package view;

import vo.ResultBall;

public class ResultView {
    public static final int STRIKE_THREE = 3;
    public static final int STRIKE_ZERO = 0;
    public static final int BALL_THREE = 0;
    public static final int BALL_ZERO = 0;

    public static Boolean resultView(ResultBall resultBall) {
        int strike = resultBall.getStrike();
        int ball = resultBall.getBall();
        if (strike == STRIKE_THREE) {
            System.out.println(
                    "3스트라이크\n"
                            + "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"
                            + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            return true;
        } else if (strike == STRIKE_ZERO && ball == BALL_ZERO) {
            System.out.println("낫싱");
        } else if (STRIKE_ZERO <= strike && strike < STRIKE_THREE && BALL_ZERO <= ball && ball < BALL_THREE) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
        return false;
    }
}
