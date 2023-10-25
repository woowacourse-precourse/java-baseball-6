package baseball.domain;

import baseball.dto.UserRequestDto;
import java.util.List;

/**
 * 2. user : 사용자가 입력한 값 - 사용자가 입력한 값을 저장 할 변수 - 게임 종료 후 restart Or exit 결정할 변수
 */
public class User {
    private final List<Integer> userValue;
    int strike = 0;
    int ball = 0;

    public User(UserRequestDto userRequestDto) {
        this.userValue = userRequestDto.getUserValue();
        this.strike = userRequestDto.getStrike();
        this.ball = userRequestDto.getBall();
    }


    public static User createUser(UserRequestDto userRequestDto) {
        return new User(userRequestDto);
    }

    public List<Integer> getUserValue() {
        return userValue;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
