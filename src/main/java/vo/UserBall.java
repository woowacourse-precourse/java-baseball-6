/*
 * <pre>
 * Class : UserBall
 * Comment: 유저가 입력한 값을 객체화
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

public class UserBall {
    private final List<Integer> userBall;

    public UserBall(List<Integer> userBall) {
        this.userBall = userBall;
    }

    public List<Integer> getUserBall() {
        return userBall;
    }
}
