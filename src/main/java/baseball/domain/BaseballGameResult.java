package baseball.domain;

import java.util.List;
import java.util.stream.Stream;

public class BaseballGameResult {

    public final int ballCount;
    public final int strikeCount;

    public BaseballGameResult(List<Integer> computerNumbs, List<Integer> userNumbs) {
        this.ballCount = ballCountProcess(computerNumbs, userNumbs);
        this.strikeCount = strikeCountProcess(computerNumbs, userNumbs);
    }

    private int ballCountProcess(List<Integer> computerNumbs, List<Integer> userNumbs) {
        return (int) Stream.iterate(0, i -> i + 1).limit(computerNumbs.size())
                .filter(num -> !computerNumbs.get(num).equals(userNumbs.get(num))
                        && computerNumbs.contains(userNumbs.get(num))).count();
    }

    private int strikeCountProcess(List<Integer> computerNumbs, List<Integer> userNumbs) {
        return (int) Stream.iterate(0, i -> i + 1).limit(computerNumbs.size())
                .filter(num -> computerNumbs.get(num).equals(userNumbs.get(num))).count();
    }
}
