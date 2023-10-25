package baseball;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {
    public static String userNumber() {
        String userNumber = Console.readLine();
        ExceptionControl.checkUserNumberInput(userNumber);
        return userNumber;
    }
    public static int restartGame() {
        String restart = Console.readLine();
        int restartCount = Integer.parseInt(restart);
        ExceptionControl.checkRestartGameInput(restartCount);
        return restartCount;
    }
}
