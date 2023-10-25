package baseball.dto;

import java.util.List;

public class UserRequestDto {
    private final List<Integer> userValue;
    int strike = 0;
    int ball = 0;

    public UserRequestDto(List<Integer> userValue) {
        this.userValue = userValue;
    }

    public static UserRequestDto createUserRequestDto(List<Integer> userValue) {
        return new UserRequestDto(userValue);
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

    public void setStrike(int strike) {
        this.strike = strike;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }
}
