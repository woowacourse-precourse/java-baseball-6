package baseball;


import camp.nextstep.edu.missionutils.Console;

public class Display {
    public static void printStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static String readLine() {
        return Console.readLine();
    }

    public static String requestUserBall() {
        System.out.print("숫자를 입력해주세요 : ");
        return readLine();
    }

    public static void printMatchResult(final MatchResult result) {
        String message = makeMatchResultMessage(result);
        System.out.println(message);
    }

    public static void printGameOver() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static String askToRestartGame() {
        System.out.printf("게임을 새로 시작하려면 %d, 종료하려면 %d를 입력하세요.\n",
                RestartType.RESTART.getValue(),
                RestartType.EXIT.getValue()
        );
        return readLine();
    }

    private static String makeMatchResultMessage(final MatchResult result) {
        if (result.isNothing) {
            return new String("낫싱");
        }
        if (isBothBallAndStrike(result)) {
            return String.format("%d볼 %d스트라이크",
                            result.ballCount,
                            result.strikeCount);
        }
        if (isOnlyBall(result)) {
            return String.format("%d볼", result.ballCount);
        }
        if (isOnlyStrike(result)) {
            return String.format("%d스트라이크", result.strikeCount);
        }
        return "";
    }

    private static boolean isBothBallAndStrike(final MatchResult result) {
        if (result.ballCount > 0 && result.strikeCount > 0) {
            return true;
        }
        return false;
    }

    private static boolean isOnlyBall(final MatchResult result) {
        if (result.ballCount > 0 && result.strikeCount == 0) {
            return true;
        }
        return false;
    }

    private static boolean isOnlyStrike(final MatchResult result) {
        if (result.strikeCount > 0 && result.ballCount == 0) {
            return true;
        }
        return false;
    }
}
