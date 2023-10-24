package others;

import camp.nextstep.edu.missionutils.Console;

public class Player {
    public static String playerInputGuessingNumber() {
        return Console.readLine().trim().replaceAll(" ", "");
    }
}
