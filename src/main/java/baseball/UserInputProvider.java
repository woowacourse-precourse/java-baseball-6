package baseball;

import camp.nextstep.edu.missionutils.Console;

public class UserInputProvider {
    private static String user;


    public static String requestUserInput() {
        return Console.readLine();
    }

}
