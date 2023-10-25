package baseball.domain.results;

import baseball.dto.BallsDifferenceDto;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Results {

    private final int strikeCount;
    private final int ballCount;
    private final int outCount;

    public Results(BallsDifferenceDto ballsDifferenceDto) {
        strikeCount = ballsDifferenceDto.getSameBallCount();
        ballCount = ballsDifferenceDto.getSameValueBallCount();
        outCount = ballsDifferenceDto.getDifferentBallCount();
    }

    public boolean isAnswer() {
        boolean noBall = ballCount == 0;
        boolean noOut = outCount == 0;
        return noBall && noOut;
    }

    @Override
    public String toString() {
        return getStringValueOfResults();
    }

    private String getStringValueOfResults() {

        String ballString = ResultStatus.BALL
                .getDescriptionWithCount(ballCount);

        String strikeString = ResultStatus.STRIKE
                .getDescriptionWithCount(strikeCount);

        String resultString = Stream.of(ballString, strikeString)
                .filter(string -> !string.equals(""))
                .collect(Collectors.joining(" "));

        if (resultString.equals("")) {
            return "낫싱";
        }

        return resultString;
    }

}
