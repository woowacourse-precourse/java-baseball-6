/*
 * <pre>
 * Class : AnswerBall
 * Comment: 컴퓨터(상대방)가 정한 난수를 객체화
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2023-10-23       손준형           최초 생성
 * 2023-10-23       손준형           record 타입 변경
 * </pre>
 *
 * @author 손준형
 * @version 1.1.0
 * @see
 */

package vo;

import java.util.List;

public record AnswerBall(List<Integer> answerBall) {
}
