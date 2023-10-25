package baseball.domain.results;

import baseball.dto.BallsDifferenceDto;
import baseball.utility.ResultsUtils;

public class Results {

    private int strikeCount = 0;
    private int ballCount = 0;
    private int outCount = 0;

    public Results(BallsDifferenceDto ballsDifferenceDto) {
        strikeCount = ballsDifferenceDto.getSameBallCount();
        ballCount = ballsDifferenceDto.getSameValueBallCount();
        outCount = ballsDifferenceDto.getDifferentBallCount();
    }

    @Override
    public String toString() {
        return ResultsUtils.getStringValueOfResults(strikeCount, ballCount);
    }

    public boolean isAnswer() {
        boolean noBall = ballCount == 0;
        boolean noOut = outCount == 0;
        return noBall && noOut;
    }

}
