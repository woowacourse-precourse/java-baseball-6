package baseball.view;

import baseball.domain.Result;

public class OutputView {
    public static void printInfo(String message) {
        System.out.print(message);
    }

    public static String printResult(Result result) {
        StringBuilder sb = new StringBuilder();
        addBallResult(result, sb);
        addStrikeResult(result, sb);

        if (sb.length() == 0) {
            sb.append("낫싱");
        }

        printInfo(sb.append('\n').toString());
        return sb.toString();
    }

    private static void addBallResult(Result result, StringBuilder sb) {
        int ballCount = result.getBallCount();
        if (ballCount != 0) {
            sb.append(ballCount).append("볼");
        }
    }

    private static void addStrikeResult(Result result, StringBuilder sb) {
        int ballCount = result.getBallCount();
        int strikeCount = result.getStrikeCount();
        if (ballCount != 0) {
            sb.append(" ");
        }
        if (strikeCount != 0) {
            sb.append(strikeCount).append("스트라이크");
        }
    }
}
