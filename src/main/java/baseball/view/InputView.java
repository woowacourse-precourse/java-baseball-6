package baseball.view;

import baseball.constants.InputMessage;
import baseball.util.StringUtil;
import baseball.util.Validator;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {
    public static List<Integer> inputPlayerNumbers() {
        System.out.print(InputMessage.INPUT_PLAYER_NUMBERS);
        String numbers = Console.readLine();
        Validator.validateInputNumbers(numbers);
        return StringUtil.convertStringToIntList(numbers);
    }

    public static int inputRestartOrExitNumber() {
        System.out.println(InputMessage.RESTART_OR_EXIT);
        String number = Console.readLine();
        Validator.validateRestartOrExitNumber(number);
        return StringUtil.convertStringToInt(number);
    }
}
