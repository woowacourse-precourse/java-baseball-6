/*
 * <pre>
 * Class : AnswerBall
 * Comment: 컴퓨터(상대방)가 정한 난수를 객체화
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

import java.util.List;

public class AnswerBall {
    private final List<Integer> answerBall;

    public AnswerBall(List<Integer> answerBall) {
        this.answerBall = answerBall;
    }

    public List<Integer> getAnswerBall() {
        return answerBall;
    }
}
