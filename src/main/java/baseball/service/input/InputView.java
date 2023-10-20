package baseball.service.input;

import baseball.util.message.PrintMessage;
import baseball.util.validator.Validator;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

public class InputView implements Input{
    @Override
    public int[] execute() {
        int[] numberArray = getNumberArray();
        Validator.validate(numberArray);
        return numberArray;
    }

    private static int[] getNumberArray() {
        PrintMessage.inputPleaseMessage();
        String nums = Console.readLine();
        return Arrays.stream(nums.split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
    }


}
