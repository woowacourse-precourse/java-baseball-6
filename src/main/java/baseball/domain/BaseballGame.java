package baseball.domain;

import baseball.io.InputConsole;
import baseball.io.OutputConsole;
import baseball.vo.ComputerNumber;

import static baseball.domain.Message.*;
import static baseball.domain.Result.*;

public class BaseballGame {

    private static final ComputerNumber COMPUTER_NUMBER = ComputerNumber.getInstance();
    private static Result result = WRONG;

    private BaseballGame() {
    }

    static {
        COMPUTER_NUMBER.createNumberList();
        OutputConsole.println(START.getMessage());
    }

    public static void start() {
        while (result == WRONG) {
            result = GameResult.getResult(COMPUTER_NUMBER.getNumberList(), InputConsole.readGameNumberList());
            if (result == CORRECT && !isRestart()) {
                break;
            }
        }
    }

    private static boolean isRestart() {
        int endOrStartNumber = InputConsole.readEndOrStartNumber();
        if (endOrStartNumber == 2) {
            return false;
        }
        if (endOrStartNumber == 1) {
            COMPUTER_NUMBER.createNumberList();
        }
        return true;
    }

}
