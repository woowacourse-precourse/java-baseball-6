package baseball.view;

import baseball.util.StringUtil;
import baseball.util.Validator;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {
    public static List<Integer> inputPlayerNumbers() {
        String numbers = Console.readLine();
        Validator.validateInputNumbers(numbers);
        return StringUtil.convertStringToIntList(numbers);
    }

    public static int inputRestartOrExitNumber() {
        String number = Console.readLine();
        Validator.validateRestartOrExitNumber(number);
        return StringUtil.convertStringToInt(number);
    }
}
