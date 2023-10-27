package baseball.domain;

import baseball.constant.Constant;
import java.util.List;
import java.util.stream.IntStream;

public class BaseballGameResult {

    public final int ballCount;
    public final int strikeCount;

    public BaseballGameResult(List<Integer> computerNumbs, UserNumber userNumbs) {
        this.ballCount = ballCountProcess(computerNumbs, userNumbs);
        this.strikeCount = strikeCountProcess(computerNumbs, userNumbs);
    }

    private int ballCountProcess(List<Integer> computerNumbs, UserNumber userNumbs) {
        return (int) IntStream.range(Constant.ZERO_NUMBER, Constant.LENGTH_LIMIT)
                .filter(num -> userNumbs.isBall(computerNumbs.get(num), num))
                .count();
    }

    private int strikeCountProcess(List<Integer> computerNumbs, UserNumber userNumbs) {
        return (int) IntStream.range(Constant.ZERO_NUMBER, Constant.LENGTH_LIMIT)
                .filter(num -> userNumbs.isStrike(computerNumbs.get(num), num))
                .count();
    }
}
