package baseball.view;

import baseball.util.Util;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {

    public static boolean askExit() {

        String userInput = Console.readLine();
        Util.validateExitCode(userInput);

        if(userInput.equals("2")) {
            return true;
        }

        return false;
    }

    public static String askUserNumbers() {

        return Console.readLine();
    }
}
