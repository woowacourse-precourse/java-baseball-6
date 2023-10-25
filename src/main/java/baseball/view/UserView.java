package baseball.view;

import baseball.model.Constants;
import camp.nextstep.edu.missionutils.Console;

import static baseball.model.Constants.*;

public class UserView {

    public void displayStartMessage() {
        System.out.println(Constants.START_MESSAGE);
    }

    public String getUserNumber() {
        System.out.println(INPUT_MESSAGE);
        String userNumber = Console.readLine();
        return userNumber;
    }

    public void displayResultMessage(String resultMessage) {
        System.out.println(resultMessage);
    }

    public static String getRestartOrEnd() {
        System.out.println(RESTART_OR_END_MESSAGE);
        String restartOrEnd = Console.readLine();
        return restartOrEnd;
    }

    public static void displayWinMessage() {
        System.out.println(WIN_MESSAGE);
    }

    public static void displayEndMessage() {
        System.out.println(END_MESSAGE);
    }
}
