package baseball.domain;

import java.util.List;
import java.util.stream.Stream;

public class BaseballGameResult {

    public final int strikeCount;
    public final int ballCount;


    public BaseballGameResult(List<Integer> computerNumbs, List<Integer> userNumbs) {
        this.strikeCount = strikeCountProcess(computerNumbs, userNumbs);
        this.ballCount = ballCountProcess(computerNumbs, userNumbs);
    }

    private int strikeCountProcess(List<Integer> computerNumbs, List<Integer> userNumbs) {
        return (int) Stream.iterate(0, i -> i + 1).limit(computerNumbs.size())
                .filter(num -> computerNumbs.get(num).equals(userNumbs.get(num))).count();
    }

    private int ballCountProcess(List<Integer> computerNumbs, List<Integer> userNumbs) {
        return 0;
    }
}
