package baseball.dto;

import baseball.model.Result;
import baseball.vo.Numbers;

public class RoundResult {
    private final Result result;
    private final boolean isFinish;

    public RoundResult(Numbers computer, Numbers user) {
        result = new Result(computer, user);
        isFinish = result.isThreeStrike();
    }

    public String getResultMessage() {
        return result.getResult();
    }

    public boolean isFinish() {
        return isFinish;
    }
}

