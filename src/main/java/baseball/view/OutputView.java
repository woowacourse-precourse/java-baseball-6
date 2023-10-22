package baseball.view;

import baseball.dto.CountResultDto;

public class OutputView {

    private OutputView() {
    }

    public static String printResult(CountResultDto countResult) {
        int strikeCount = countResult.getStrikeCount();
        int ballCount = countResult.getBallCount();
        if (strikeCount == ballCount && strikeCount > GameValue.ZERO.getValue()) {
            return strikeCount + GameMessage.STRIKE.getMessage();
        }
        if (strikeCount == GameValue.ZERO.getValue() && ballCount > GameValue.ZERO.getValue()) {
            return ballCount + GameMessage.BALL.getMessage();
        }
        if (strikeCount > GameValue.ZERO.getValue() && ballCount - strikeCount > GameValue.ZERO.getValue()) {
            String ballMessage = (ballCount - strikeCount) + GameMessage.BALL.getMessage();
            String strikeMessage = strikeCount + GameMessage.STRIKE.getMessage();
            return String.join(" ", ballMessage, strikeMessage);
        }
        return GameMessage.NOTHING.getMessage();
    }
}
