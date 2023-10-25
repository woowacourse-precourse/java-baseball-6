package baseball.util;

import static baseball.util.OutputUtil.printInsertInputMessage;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputUtil {
    public static String inputGuessNumber() {
        printInsertInputMessage();
        return readLine();
    }
}
