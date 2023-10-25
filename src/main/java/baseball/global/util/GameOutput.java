package baseball.global.util;

import static baseball.global.enums.GuideMessage.FINISH_GUIDE;
import static baseball.global.enums.GuideMessage.INPUT_COMMAND;
import static baseball.global.enums.GuideMessage.RESTART_MENU;

/**
 * 공통된 출력 커맨드를 관리하는 클래스
 */
public final class GameOutput {

    public static void printResult(String result) {
        System.out.println(result);
    }

    public static void printFinish() {
        System.out.println(FINISH_GUIDE.message);
    }

    public static void printRestart() {
        System.out.println(RESTART_MENU.message);
    }

    public static void inputCommand() {
        System.out.print(INPUT_COMMAND.message);
    }
}
