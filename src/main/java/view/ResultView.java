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

import java.util.List;

public class ResultView {
    public static Boolean resultView(List<Integer> result) {
        if (result.get(0) == 3) {
            System.out.println(
                    "3스트라이크\n"
                            + "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"
                            + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            return true;
        } else if (result.get(0) == 0 && result.get(1) == 0) {
            System.out.println("낫싱");
        } else {
            System.out.println(result.get(1) + "볼 " + result.get(0) + "스트라이크");
        }
        return false;
    }
}
