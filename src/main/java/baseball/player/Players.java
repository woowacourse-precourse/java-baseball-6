package baseball.player;

import baseball.result.Result;

/**
 * 숫자 야구 게임을 플레이하는 User와 Computer를 그룹화하여 저장하는 클래스다. 이 후, 멀티 플레이어를 지원할 경우 확장성에 염두를 두었다.
 *
 * @author Seongha Park
 */
public class Players {
    private User user;
    private Computer computer;

    /**
     * User에게 입력받아 숫자를 생성한다.
     */
    public void createUserNumber() {
        user = new User();
        user.createNumbers();
    }

    /**
     * Computer의 숫자를 랜덤으로 생성한다.
     */
    public void createComputerNumber() {
        computer = new Computer();
        computer.createNumbers();
    }

    public Result compareNumbers() {
        return user.compareWith(computer);
    }
}
