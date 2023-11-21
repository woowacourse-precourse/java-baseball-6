package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static void welcome() {
        System.out.println(GuideMessage.GAME_START);
    }

    public static String requestNumbers() {
        System.out.print(GuideMessage.REQUEST_NUMBERS);
        return Console.readLine();
    }

    public static String askRestart() {
        System.out.println(GuideMessage.REQUEST_RESTART);
        return Console.readLine();
    }
}
