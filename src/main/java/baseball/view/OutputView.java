package baseball.view;

import static baseball.common.Constants.BALL;
import static baseball.common.Constants.NOTHING;
import static baseball.common.Constants.STRIKE;

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
            sb.append(NOTHING);
        }

        printInfo(sb.append('\n').toString());
        return sb.toString();
    }

    private static void addBallResult(Result result, StringBuilder sb) {
        int ballCount = result.getBallCount();
        if (ballCount != 0) {
            sb.append(ballCount).append(BALL);
        }
    }

    private static void addStrikeResult(Result result, StringBuilder sb) {
        int ballCount = result.getBallCount();
        int strikeCount = result.getStrikeCount();
        if (ballCount != 0) {
            sb.append(" ");
        }
        if (strikeCount != 0) {
            sb.append(strikeCount).append(STRIKE);
        }
    }
}
