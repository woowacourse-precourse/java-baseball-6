package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Utils {

    private Utils() {}

    public static String printAndInput(String message) {
        System.out.print(message);
        return Console.readLine();
    }
}
