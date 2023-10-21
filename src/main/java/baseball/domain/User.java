package baseball.domain;

import baseball.validator.BaseballValidator;
import java.util.List;

public class User  {
    private List<Integer> userBall;

    public void setUserBall(List<Integer> baseball) {
        if (BaseballValidator.validator(baseball)) {
            this.userBall = baseball;
        }
    }

    public List<Integer> getUserBall() {
        return userBall;
    }

}
