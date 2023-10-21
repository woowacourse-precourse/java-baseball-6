package baseball.view.output;

import baseball.dto.ComparisonResult;

class ComparisonResultView {

    private static final String STRIKE_FORMAT = "%d스트라이크 ";
    private static final String BALL_FORMAT = "%d볼 ";
    private static final String NOTHING = "낫싱";

    ComparisonResultView() {
    }

    String changeToOutputMessage(ComparisonResult result) {
        String message = makeCountMessage(result);

        if (message.isBlank()) {
            return NOTHING;
        }
        return message;
    }

    private String makeCountMessage(ComparisonResult result) {
        StringBuilder builder = new StringBuilder();
        if (isBallExist(result)) {
            builder.append(makeBallFormat(result.ball()));
        }
        if (isStrikeExist(result)) {
            builder.append(makeStrikeFormat(result.strike()));
        }
        return builder.toString().trim();
    }

    private boolean isBallExist(ComparisonResult result) {
        return result.ball() != 0;
    }

    private String makeBallFormat(int ball) {
        return String.format(BALL_FORMAT, ball);
    }

    private boolean isStrikeExist(ComparisonResult result) {
        return result.strike() != 0;
    }

    private String makeStrikeFormat(int strike) {
        return String.format(STRIKE_FORMAT, strike);
    }
}
