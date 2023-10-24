package baseball;

import camp.nextstep.edu.missionutils.Console;

public class UserInterface {
    private static String user;


    public static String requestUserInput() {
        return Console.readLine();
    }

    public static void printMessage (Message message) {
        System.out.println(message.getMessage());
    }
}
