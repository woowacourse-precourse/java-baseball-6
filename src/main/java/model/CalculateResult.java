/*
 * <pre>
 * Class : CalculateResult
 * Comment: 제시된 난수와 사용자가 입력한 수를 비교
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2023-10-22       손준형           최초 생성
 * 2023-10-23       손준형           난수와 사용자 입력, 반환값에 대해 일급 컬렉션 적용
 * 2023-10-23       손준형           매직넘버 상수 대체
 * 2023-10-23       손준형           클래스 이름 변경
 * 2023-10-23       손준형           스트라이크 볼 개수 판단 로직 추가
 * 2023-10-24       손준형           매직넘버 상수 대체(strike, ball 수)
 * </pre>
 *
 * @author 손준형
 * @version 1.1.4
 * @see
 */

package model;

import java.util.List;
import java.util.Objects;
import vo.AnswerBall;
import vo.ResultBall;
import vo.UserBall;

public class CalculateResult {
    public static final int NUMBER_SIZE = 3;
    public static final int MIN_STRIKE = 0;
    public static final int MAX_STRIKE = 3;
    public static final int MIN_BALL = 0;
    public static final int MAX_BALL = 3;

    public static boolean isThreeStrikes(ResultBall resultBall) {
        return resultBall.strike() == 3;
    }

    public static boolean isNothing(ResultBall resultBall) {
        return resultBall.strike() == MIN_STRIKE && resultBall.ball() == MIN_BALL;
    }

    public static boolean isValid(ResultBall resultBall) {
        return MIN_STRIKE <= resultBall.strike() && resultBall.strike() <= MAX_STRIKE && MIN_BALL <= resultBall.ball() && resultBall.ball() <= MAX_BALL;
    }

    public static ResultBall getResult(AnswerBall answerBall, UserBall userBall) {
        List<Integer> answer = answerBall.answerBall();
        List<Integer> user = userBall.userBall();
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < NUMBER_SIZE; i++) {
            if (Objects.equals(answer.get(i), user.get(i))) {
                strike++;
            } else if (user.contains(answer.get(i))) {
                ball++;
            }
        }
        return new ResultBall(strike, ball);
    }
}
