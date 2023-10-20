package baseball.view;

import baseball.PlayResult;
import java.util.StringJoiner;

public class OutputView {

    private static final String PLAY_RESULT_DELIMITER = " ";

    private static final String STRIKE_DELIMITER = "\n";

    public static void printGameStartMessage() {
        System.out.println(ConsoleMessage.GAME_START.message);
    }

    public static void printResult(final PlayResult result) {
        System.out.println(formatPlayResult(result));
    }

    private static String formatPlayResult(final PlayResult result) {

        if (result.isNothing()) {
            return ConsoleMessage.RESULT_NOTHING.message;
        }
        final StringJoiner messages = new StringJoiner(PLAY_RESULT_DELIMITER);
        messages.add(formatBall(result));
        messages.add(formatStrike(result));
        return messages.toString()
                .strip();
    }

    private static String formatBall(final PlayResult result) {
        return formatCountOf(Format.BALL, result.getBalls());
    }

    private static String formatStrike(final PlayResult result) {
        final StringJoiner messages = new StringJoiner(STRIKE_DELIMITER);
        messages.add(formatCountOf(Format.STRIKE, result.getStrikes()));

        if (result.isAllStrike()) {
            messages.add(ConsoleMessage.RESULT_ALL_STRIKE.message);
        }
        return messages.toString();
    }

    private static String formatCountOf(final Format format, final long count) {

        if (count == 0L) {
            return "";
        }
        return format.toMessage(count);
    }

    private enum Format {
        BALL("%d볼"),
        STRIKE("%d스트라이크");

        private final String format;

        Format(final String format) {
            this.format = format;
        }

        public String toMessage(final Object... args) {
            return String.format(format, args);
        }
    }

    private enum ConsoleMessage {
        GAME_START("숫자 야구 게임을 시작합니다."),
        RESULT_NOTHING("낫싱"),
        RESULT_ALL_STRIKE("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

        private final String message;

        ConsoleMessage(final String message) {
            this.message = message;
        }
    }
}
