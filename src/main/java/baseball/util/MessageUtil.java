package baseball.util;

import baseball.constant.Message;
import baseball.domain.BaseballCount;

/**
 * 메시지 출력을 위한 메서드를 가지는 유틸 클래스
 */
public final class MessageUtil {

    public static void printStartMsg() {
        System.out.println(Message.GAME_START_MSG);
    }

    public static void printInputMsg() {
        System.out.print(Message.INPUT_MSG);
    }

    public static void printBaseballCount(BaseballCount count) {
        if (count.getBall() == 0 && count.getStrike() == 0) {
            System.out.println(Message.NOTHING_MSG);
            return;
        }
        if (count.getBall() != 0) {
            System.out.print(count.getBall() + Message.BALL_MSG + " ");
        }
        if (count.getStrike() != 0) {
            System.out.print(count.getStrike() + Message.STRIKE_MSG);
        }
        System.out.println();
    }

    public static void printFinishMsg() {
        System.out.println(Message.GAME_FINISH_MSG);
    }

    public static void printRestartMsg() {
        System.out.println(Message.GAME_RESTART_MSG);
    }
}
