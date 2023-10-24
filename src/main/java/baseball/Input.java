package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.lang.reflect.Type;

import static baseball.ErrorMessage.*;
import static baseball.Validator.*;

public class Input {
    public String readUserNumber() {
        String userNumber = Console.readLine();
        validateUserNumber(userNumber);
        return userNumber;
    }

    public boolean isRestart() {
        String restartNumber = Console.readLine();
        if (!isNumber(restartNumber)) {
            throw new IllegalArgumentException(NOT_NUMERIC.getMessage());
        }
        if (!isInRange(restartNumber, 1, 2)) {
            throw new IllegalArgumentException(WRONG_RESET_COMMAND.getMessage());
        }
        if (restartNumber.equals("1")) {
            return true;
        }
        return false;
    }


}
