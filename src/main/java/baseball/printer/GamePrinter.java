package baseball.printer;

import baseball.domain.RoundResult;

public class GamePrinter {
    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String REQUIRE_USER_BASEBALL_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String WIN_ROUND_MESSAGE = "게임 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RE_GAME_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String BALL_MESSAGE = "볼";
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String NOTHING_MESSAGE = "낫싱";

    public static void printStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public static void printRequireNumberMessage() {
        System.out.print(REQUIRE_USER_BASEBALL_MESSAGE);
    }

    public static void printRoundResult(RoundResult roundResult) {
        if (roundResult.isNothing()) {
            System.out.println(NOTHING_MESSAGE);
        } else if (roundResult.isOnlyStrike()) {
            System.out.println(roundResult.getStrikeCount() + STRIKE_MESSAGE);
        } else if (roundResult.isOnlyBall()) {
            System.out.println(roundResult.getBallCount() + BALL_MESSAGE);
        } else if (roundResult.isBothOccured()) {
            System.out.println(
                    roundResult.getBallCount() + BALL_MESSAGE + " " + roundResult.getStrikeCount() + STRIKE_MESSAGE);
        }
    }

    public static void printWinMessage() {
        System.out.println(WIN_ROUND_MESSAGE);
    }

    public static void printReGameMessage() {
        System.out.println(RE_GAME_MESSAGE);
    }
}
