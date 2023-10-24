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

    public static List<Integer> askUserNumbers() {

        String userString = Console.readLine();

        Util.validateUserString(userString);

        List<Integer> userNumbers = Util.stringToIntegerList(userString);

        return userNumbers;
    }
}
