package baseball.view;

import baseball.domain.dto.Result;

import static baseball.global.message.GameMessage.*;

public class OutputView {
    
    public void responseResult(Result result){
        System.out.println(makeUserScoreMessage(result));
    }
    private String makeUserScoreMessage(Result result) {
        if (result.isNothing()) {
            return NOTHING.getMessage();
        } else if (result.getBall() == 0) {
            return makeStrikeMessageIfExists(result.getStrike());
        }
        return makeBallMessageIfExists(result.getBall()) +
                " " +
                makeStrikeMessageIfExists(result.getStrike());
    }

    private String makeBallMessageIfExists(int ballCount) {
        if (ballCount == 0) {
            return "";
        }
        return ballCount + BALL.getMessage();
    }

    private String makeStrikeMessageIfExists(int strikeCount) {
        if (strikeCount == 0) {
            return "";
        }
        return strikeCount + STRIKE.getMessage();
    }
}
