package baseball.input;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static String inputString(String input) {
        System.out.print(input);
        return Console.readLine();
    }
}
