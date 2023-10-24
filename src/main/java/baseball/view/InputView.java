package baseball.view;

import baseball.util.Conversion;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import baseball.exception.InputException;

import static baseball.Config.*;

public class InputView {
    public ArrayList<Integer> numberInput() {
        System.out.print(INPUT_NUMBER_MESSAGE);
        String input = Console.readLine();
        InputException.validateInput(input);
        return Conversion.stringToArrayList(input);
    }

    public Integer restartInput() {
        System.out.println(RESTART_INPUT_NUMBER_MESSAGE);
        String input = Console.readLine();
        InputException.validateRestartInput(input);
        return Integer.parseInt(input);
    }
}
