package baseball.view;

import static baseball.config.OutputViewConfig.GAME_START;
import static baseball.config.OutputViewConfig.NOTHING;
import static baseball.config.OutputViewConfig.REQUEST_PLAYER_NUMBER;
import static baseball.config.OutputViewConfig.REQUEST_RESTART_OR_EXIT;

public class OutputView {
    public static void printRequestNumber() {
        System.out.print(REQUEST_PLAYER_NUMBER.getMessage());
    }

    public static void printGameStart() {
        System.out.println(GAME_START.getMessage());
    }


    public static void printRequestRestartOrExit() {
        System.out.println(REQUEST_RESTART_OR_EXIT.getMessage());
    }

    public static void printNothing() {
        System.out.println(NOTHING.getMessage());
    }

    public static void printBallCount(int ballCount) {
        String result = String.format("%d볼", ballCount);
        System.out.println(result);
    }

    public static void printStrikeCount(int strikeCount) {
        String result = String.format("%d스트라이크", strikeCount);
        System.out.println(result);
    }

    public static void printBallAndStrikeCount(int ballCount, int strikeCount) {
        String result = String.format("%d볼 %d스트라이크", ballCount, strikeCount);
        System.out.println(result);
    }

    public static void printEmptyLine() {
        System.out.println();
    }

    public static void printGameOver() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
