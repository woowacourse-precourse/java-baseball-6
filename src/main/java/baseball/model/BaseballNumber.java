package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class BaseballNumber {
    private final List<BallNumber> baseballNumberList;

    public BaseballNumber(List<BallNumber> baseballNumberSet) {
        this.baseballNumberList = new ArrayList<>(baseballNumberSet);
    }

    public Result compare(BaseballNumber userNumber) {
        int strike = 0;
        int ball = 0;

        List<BallNumber> userBallNumberList = userNumber.baseballNumberList;
        for (int i = 0; i < baseballNumberList.size(); i++) {
            BallNumber computerBallNumber = baseballNumberList.get(i);
            BallNumber userBallNumber = userBallNumberList.get(i);

            if (computerBallNumber.equals(userBallNumber)) {
                strike++;
            } else if (baseballNumberList.contains(userBallNumber)) {
                ball++;
            }
        }

        return new Result(strike, ball);
    }
}
