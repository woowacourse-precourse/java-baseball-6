package baseball.domain.view;

import baseball.domain.dto.ResultDto;

import java.util.Map;

public class OutputData {
    public static final String THREE_STRIKE_WIN_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String OUT = "아웃";
    public static final String BALL = "볼";
    public static final String STRIKE = "스트라이크";

    private static String output = "";

    private OutputData() {
    }

    private static void printOutput() {
        System.out.print(output);
        System.out.println();
        output = "";
    }

    private static String printOutCount(int count) {
        if (3 == count) {
            return "낫싱";
        }
        return "";
    }

    private static String printBallCount(String ballCount, int count) {
        if (0 != count) {
            return count + ballCount;
        }
        return "";
    }

    private static String printStrikeCount(String ballCount, int count) {
        if (3 == count) {
            return count + ballCount + "\n" + THREE_STRIKE_WIN_MESSAGE;
        }
        if (0 != count) {
            return checkJustStrike(ballCount, count);
        }
        return "";
    }

    private static String checkJustStrike(String ballCount, int count) {
        if ("".equals(output)) {
            return count + ballCount;
        }
        return " " + count + ballCount;
    }

}
