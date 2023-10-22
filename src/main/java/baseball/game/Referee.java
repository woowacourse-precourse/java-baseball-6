package baseball.game;

import baseball.domain.ComputerBaseballs;
import baseball.domain.UserBaseballs;
import baseball.dto.Result;

public class Referee {

    public Result createResult(ComputerBaseballs computerBaseballs, UserBaseballs userBaseballs) {
        int ballCount = computerBaseballs.countBall(userBaseballs);
        int strikeCount = computerBaseballs.countStrike(userBaseballs);

        return new Result(ballCount, strikeCount);
    }

    public boolean isUserWin(Result result) {
        return result.isAllStrike();
    }
}
