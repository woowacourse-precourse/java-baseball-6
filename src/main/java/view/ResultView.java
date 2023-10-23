/*
 * <pre>
 * Class : ResultView
 * Comment: 사용자 입력과 난수를 비교한 결과 출력
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2023-10-22       손준형           최초 생성
 * 2023-10-23       손준형           스트라이크 볼 개수 판단 로직 분리
 * </pre>
 *
 * @author 손준형
 * @version 1.1.0
 * @see
 */

package view;

import model.CalculateResult;
import vo.ResultBall;

public class ResultView {

    public static void View(ResultBall resultBall) {
        if (CalculateResult.isThreeStrikes(resultBall)) {
            System.out.println(
                    """
                            3스트라이크
                            3개의 숫자를 모두 맞히셨습니다! 게임 종료
                            게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.""");
        } else if (CalculateResult.isNothing(resultBall)) {
            System.out.println("낫싱");
        } else if (CalculateResult.isValid(resultBall)) {
            System.out.println(resultBall.ball() + "볼 " + resultBall.strike() + "스트라이크");
        }
    }
}
