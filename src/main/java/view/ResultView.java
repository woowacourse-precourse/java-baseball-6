/*
 * <pre>
 * Class : ResultView
 * Comment: 사용자 입력과 난수를 비교한 결과 출력
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2023-10-22       손준형           최초 생성
 * </pre>
 *
 * @author 손준형
 * @version 1.0.0
 * @see
 */

package view;

import vo.ResultBall;

public class ResultView {
    private static int strike;
    private static int ball;

    public ResultView(ResultBall resultBall) {
        strike = resultBall.strike();
        ball = resultBall.ball();
    }

    public boolean isThreeStrikes() {
        return strike == 3;
    }

    public boolean isNothing() {
        return strike == 0 && ball == 0;
    }

    public boolean isValid() {
        return 0 <= strike && strike <= 3 && 0 <= ball && ball <= 3;
    }

    public void View() {
        if (isThreeStrikes()) {
            System.out.println(
                    "3스트라이크\n"
                            + "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"
                            + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        } else if (isNothing()) {
            System.out.println("낫싱");
        } else if (isValid()) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }
}
