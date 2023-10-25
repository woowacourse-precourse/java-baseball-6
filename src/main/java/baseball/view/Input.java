package baseball.view;

import baseball.validation.Validation;
import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static int readNumber() throws IllegalArgumentException {
        String input = Console.readLine();
        Validation.checkLength(input);
        Validation.checkNumber(input);
        return stringToInt(input);
    }

    public static boolean readExitNumber() throws IllegalArgumentException {
        String input = Console.readLine();
        Validation.checkNumberIsOneOrTwo(input);
        return stringToInt(input) == 1;
    }


    private static int stringToInt(String input) {
        return Integer.parseInt(input);
    }
}
