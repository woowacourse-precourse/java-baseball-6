package baseball.view;

import baseball.dto.response.GameResultResponse;

import static baseball.view.message.GameMessage.EXIT_MESSAGE;
import static baseball.view.message.GameMessage.GAME_OVER_MESSAGE;
import static baseball.view.message.GameMessage.RESULT_BALL_FORMAT;
import static baseball.view.message.GameMessage.RESULT_NOTHING;
import static baseball.view.message.GameMessage.RESULT_REGEXP;
import static baseball.view.message.GameMessage.RESULT_STRIKE_FORMAT;
import static baseball.view.message.GameMessage.START_MESSAGE;

public class OutputView {
    public static void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public static void printResult(final GameResultResponse gameResultResponse) {
        final int ballCount = gameResultResponse.getBallCount();
        final int strikeCount = gameResultResponse.getStrikeCount();

        if (ballCount == 0 && strikeCount == 0) {
            System.out.println(RESULT_NOTHING);
            return;
        }

        final StringBuilder stringBuilder = getResultStringBuilder(ballCount, strikeCount);
        System.out.println(stringBuilder);
    }

    private static StringBuilder getResultStringBuilder(final int ballCount, final int strikeCount) {
        final StringBuilder stringBuilder = new StringBuilder();
        if (ballCount > 0) {
            stringBuilder.append(String.format(RESULT_BALL_FORMAT, ballCount));
        }

        if (strikeCount > 0) {
            if (ballCount != 0) {
                stringBuilder.append(RESULT_REGEXP);
            }
            stringBuilder.append(String.format(RESULT_STRIKE_FORMAT, strikeCount));
        }

        return stringBuilder;
    }

    public static void printGameOverMessage() {
        System.out.println(GAME_OVER_MESSAGE);
    }

    public static void printExitMessage() {
        System.out.println(EXIT_MESSAGE);
    }
}
