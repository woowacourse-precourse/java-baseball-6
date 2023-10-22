package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public static String readNumber() {
        String number = Console.readLine();
        ErrorDetector.throwIfNumberIsWrong(number);
        return number;
    }

    public static String readOption() {
        String option = Console.readLine();
        ErrorDetector.throwIfOptionIsWrong(option);
        return option;
    }
}
