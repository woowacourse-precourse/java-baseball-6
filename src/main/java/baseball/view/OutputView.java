package baseball.view;

import baseball.entity.PlayResult;

public class OutputView {

    private static final String INTRO_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String OUTRO_MESSAGE_FORMAT = "%d개의 숫자를 모두 맞히셨습니다! 게임 종료%n";
    private static final String BALL_POSTFIX = "볼 ";
    private static final String STRIKE_POSTFIX = "스트라이크";
    private static final String NOTHING_MESSAGE = "낫싱";

    public static void printIntro() {
        System.out.println(INTRO_MESSAGE);
    }

    public static void printOutro(int maxBallsSize) {
        System.out.format(OUTRO_MESSAGE_FORMAT, maxBallsSize);
    }

    public static void printResult(PlayResult result) {
        StringBuilder sb = new StringBuilder();

        appendMessage(sb, result.ballCount(), BALL_POSTFIX);
        appendMessage(sb, result.strikeCount(), STRIKE_POSTFIX);
        appendMessageIfAbsent(sb);
        removeLastWhitespaceIfPresent(sb);

        System.out.println(sb);
    }

    private static void appendMessage(StringBuilder sb, int count, String postfix) {
        if (count > 0) {
            sb.append(count);
            sb.append(postfix);
        }
    }

    private static void appendMessageIfAbsent(StringBuilder sb) {
        if (sb.isEmpty()) {
            sb.append(NOTHING_MESSAGE);
        }
    }

    private static void removeLastWhitespaceIfPresent(StringBuilder sb) {
        if (!sb.isEmpty()) {
            int lastIndex = sb.length() - 1;

            if (Character.isWhitespace(sb.charAt(lastIndex))) {
                sb.deleteCharAt(lastIndex);
            }
        }
    }
}
