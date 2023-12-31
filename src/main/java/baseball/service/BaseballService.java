package baseball.service;

import baseball.model.Ball;
import baseball.model.Result;

public class BaseballService {

    private Result result;

    public void check(Ball answer, Ball player) {
        result = new Result(answer, player);
    }

    public Result getResult() {
        return result;
    }

    public boolean isStrikeOut() {
        return result.isStrikeOut();
    }

}
