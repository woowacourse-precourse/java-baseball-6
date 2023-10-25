package baseball.view;

public class OutputView {

    private static final String STARTING_PROMPT = "숫자 야구 게임을 시작합니다.";
    private static final String WINNING_PROMPT = "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String BALL_TEXT = "볼";
    private static final String STRIKE_TEXT = "스트라이크";
    private static final String NOTHING_TEXT = "낫싱";

    public static void printGameStartingPrompt() {
        System.out.println(STARTING_PROMPT);
    }

    public static void printGameResult(int ballCount, int strikeCount) {
        String gameResultPrompt = getResultPrompt(ballCount, strikeCount);

        System.out.println(gameResultPrompt);
    }

    private static String getResultPrompt(int ballCount, int strikeCount) {
        if (ballCount == 0 && strikeCount == 0) {
            return NOTHING_TEXT;
        }

        String resultPrompt = getBallPrompt(ballCount)
            + " "
            + getStrikePrompt(strikeCount);
        return resultPrompt.trim();
    }

    public static void printWinningPrompt(int numberSize) {
        System.out.println(numberSize + WINNING_PROMPT);
    }

    private static String getBallPrompt(int ballCount) {
        if (ballCount == 0) {
            return "";
        }

        return ballCount + BALL_TEXT;
    }

    private static String getStrikePrompt(int strikeCount) {
        if (strikeCount == 0) {
            return "";
        }

        return strikeCount + STRIKE_TEXT;
    }
}
