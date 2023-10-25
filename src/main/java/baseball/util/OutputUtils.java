package baseball.util;

public class OutputUtils {
    private static final String OUTPUT_BALL_MESSAGE = "볼";
    private static final String OUTPUT_STRIKE_MESSAGE = "스트라이크";
    private static final String OUTPUT_NOTHING_MESSAGE = "낫싱";

    public static void printGameStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printGameSetMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void printUserInputMessage() {
        System.out.print("숫자를 입력해주세요: ");
    }

    public static void printRestartGameMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public static void printCurrentResult(int strikeCount, int ballCount) {
        StringBuilder resultText = new StringBuilder();

        resultText.append(getBallOutput(ballCount))
                .append(getStrikeOutput(strikeCount))
                .append(getNothingOutput(strikeCount, ballCount));

        System.out.println(resultText);
    }

    private static StringBuilder getStrikeOutput(int strikeCount) {
        StringBuilder strikeResult = new StringBuilder();
        if (strikeCount > 0) {
            strikeResult.append(strikeCount)
                    .append(OUTPUT_STRIKE_MESSAGE);
        }
        return strikeResult;
    }

    private static StringBuilder getBallOutput(int ballCount) {
        StringBuilder ballResult = new StringBuilder();
        if (ballCount > 0) {
            ballResult.append(ballCount)
                    .append(OUTPUT_BALL_MESSAGE)
                    .append(" ");
        }
        return ballResult;
    }

    private static StringBuilder getNothingOutput(int strikeCount, int ballCount) {
        StringBuilder nothingResult = new StringBuilder();
        if (ballCount == 0 && strikeCount == 0) {
            nothingResult.append(OUTPUT_NOTHING_MESSAGE);
        }
        return nothingResult;
    }
}
