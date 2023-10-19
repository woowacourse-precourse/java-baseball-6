package baseball.domain;

import java.util.List;

/**
 * 2. user : 사용자가 입력한 값
 * - 사용자가 입력한 값을 저장 할 변수
 * - 게임 종료 후 restart Or exit 결정할 변수
 */
public class User {
    private final List<Integer> userValue;
    private int selectEnd;
    int strike = 0;
    int ball = 0;

    public User(List<Integer> userValue, int selectEnd) {
        this.userValue = userValue;
        this.selectEnd = selectEnd;
    }

    public User(List<Integer> userValue) {
        this.userValue = userValue;
    }

    public static User createUser(List<Integer> userValue) {
        return new User(userValue);
    }

    public static User createUser(List<Integer> userValue, int selectEnd) {
        return new User(userValue, selectEnd);
    }

    public List<Integer> getUserValue() {
        return userValue;
    }

    public int getSelectEnd() {
        return selectEnd;
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
