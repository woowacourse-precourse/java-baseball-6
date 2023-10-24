package baseball.io;

import baseball.domain.Baseball;
import baseball.domain.RoundResult;

public class OutputProcessor {
    private static final String NOTHING = "낫싱";
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String SEPARATOR = " ";

    private OutputProcessor() {
    }

    public static void printGameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printGameResult(final RoundResult result) {
        System.out.println(refineGameResult(result));
    }

    private static String refineGameResult(final RoundResult result) {
        if (!hasStrikeCount(result) && !hasBallCount(result)) {
            return NOTHING;
        }

        final StringBuilder resultFormat = new StringBuilder();

        if (hasBallCount(result)) {
            resultFormat.append(result.ballCount())
                    .append(BALL);
        }

        if (hasStrikeCount(result)) {
            resultFormat.append(SEPARATOR)
                    .append(result.strikeCount())
                    .append(STRIKE);
        }

        return resultFormat.toString();
    }

    private static boolean hasBallCount(final RoundResult result) {
        return result.ballCount() > 0;
    }

    private static boolean hasStrikeCount(final RoundResult result) {
        return result.strikeCount() > 0;
    }

    public static void printGameClear() {
        System.out.printf("%d개의 숫자를 모두 맞히셨습니다! 게임 종료\n", Baseball.TOTAL_COUNT);
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
