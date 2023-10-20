package baseball.service.input;

import baseball.util.error.ErrorMessage;
import baseball.util.message.PrintMessage;
import baseball.util.validator.Validator;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

public class InputView implements Input{
    @Override
    public int[] execute() {
        return getNumberArray();
    }

    private static int[] getNumberArray() {
        PrintMessage.inputPleaseMessage();
        String nums = Console.readLine();
        return Validator.validate(nums);
    }


}
