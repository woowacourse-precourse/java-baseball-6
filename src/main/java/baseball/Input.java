package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public static String readNumber() {
        String playerBall = Console.readLine();
        ErrorDetector.throwIfNumberIsWrong(playerBall);
        return playerBall;
    }

    public static String readOption() {
        String option = Console.readLine();
        ErrorDetector.throwIfOptionIsWrong(option);
        return option;
    }
}
