package baseball.domain;

import baseball.feature.GamePrint;
import baseball.feature.StrikeBallCount;
import java.util.List;

public class Computer {

    private final GamePrint gamePrint = new GamePrint();
    private final StrikeBallCount strikeBallCount = new StrikeBallCount();

    public boolean compareNumber(List<Integer> computer, List<Integer> user) {
        int strike = strikeBallCount.countStrike(computer, user);
        int ball = strikeBallCount.countBall(computer, user);
        gamePrint.printGameResult(strike, ball);
        return strike == 3;
    }

}
