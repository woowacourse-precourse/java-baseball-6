package baseball.domain.result;

import baseball.domain.result.resultnum.BallNum;
import baseball.domain.result.resultnum.ResultNum;
import baseball.domain.result.resultnum.StrikeNum;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class GameResult {
    private static final String DELIMITER = " ";
    private static final String NOTHING = "낫싱";
    private final List<ResultNum> resultNumbers;

    public GameResult() {
        resultNumbers = new ArrayList<>();
        resultNumbers.add(new BallNum());
        resultNumbers.add(new StrikeNum());
    }

    public void update(BallResult ballResult) {
        resultNumbers.replaceAll(resultNum -> resultNum.update(ballResult));
    }

    public String getResult() {
        String result = resultNumbers.stream().map(ResultNum::getResult)
                        .filter(Optional::isPresent)
                        .map(Optional::get)
                        .collect(Collectors.joining(DELIMITER));
        if (result.isEmpty()) {
            result = NOTHING;
        }
        return result;
    }

    public boolean isGameEnd() {
        return resultNumbers.stream()
                .map(ResultNum::isGameEnd)
                .reduce((result1, result2) -> result1 && result2)
                .orElse(false);
    }
}