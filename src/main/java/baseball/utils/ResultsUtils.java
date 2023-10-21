package baseball.utils;

import baseball.balls.Ball;
import baseball.balls.Balls;
import baseball.results.ResultStatus;
import baseball.results.Results;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class ResultsUtils {

    public static Results determineResults(Balls balls, Balls anotherBalls) {
        Results results = new Results();

        for (Ball ball : balls.getBalls()) {
            ResultStatus resultStatus = determineResultStatus(anotherBalls, ball);
            results.addResultStatus(resultStatus);
        }

        return results;
    }

    public static ResultStatus determineResultStatus(Balls balls, Ball ball) {
        if (balls.hasSameBall(ball)) {
            return ResultStatus.STRIKE;
        }

        if (balls.hasSameValueBall(ball)) {
            return ResultStatus.BALL;
        }

        return ResultStatus.OUT;
    }

    public static String getStringValueOfResultStatusWithCount(ResultStatus resultStatus, int count) {
        if (count == 0) {
            return "";
        }
        String description = resultStatus.getDescription();
        return count + description;
    }

    public static String getStringValueOfResults(int strikeCount, int ballCount) {

        String ballString = ResultsUtils.getStringValueOfResultStatusWithCount(
                ResultStatus.BALL, ballCount
        );

        String strikeString = ResultsUtils.getStringValueOfResultStatusWithCount(
                ResultStatus.STRIKE, strikeCount
        );

        String resultString = Stream.of(ballString, strikeString)
                .filter(string -> !string.equals(""))
                .collect(Collectors.joining(" "));

        if (resultString.equals("")) {
            return "낫싱";
        }

        return resultString;
    }

}
