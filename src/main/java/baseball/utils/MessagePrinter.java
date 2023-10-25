package baseball.utils;

import static baseball.utils.AppConstants.GAME_END_NUMBER;
import static baseball.utils.AppConstants.GAME_RESTART_NUMBER;

public class MessagePrinter {
    public static void printGameStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printRequestPlayerInputMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void printRestartGameMessage() {
        System.out.println("게임을 새로 시작하려면 " + GAME_RESTART_NUMBER + ", 종료하려면 " + GAME_END_NUMBER + "를 입력하세요.");
    }

    public static void printStrikeAndBallMessage(String result) {
        System.out.println(result);
    }

    public static void printWinnerMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
