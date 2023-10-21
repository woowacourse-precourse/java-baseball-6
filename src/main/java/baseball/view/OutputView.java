package baseball.view;

import baseball.entity.PlayResult;

public class OutputView {

    private static final String INTRO_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String BALL_POSTFIX = "볼 ";
    private static final String STRIKE_POSTFIX = "스트라이크";
    private static final String NOTHING_MESSAGE = "낫싱";

    public static void printIntro() {
        System.out.println(INTRO_MESSAGE);
    }

    public static void printResult(PlayResult result) {
        StringBuilder sb = new StringBuilder();

        appendMessage(sb, result.getBallCount(), BALL_POSTFIX);
        appendMessage(sb, result.getStrikeCount(), STRIKE_POSTFIX);
        appendMessageIfAbsent(sb);

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
}
