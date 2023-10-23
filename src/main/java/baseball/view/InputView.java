package baseball.view;

import baseball.util.StringUtil;
import baseball.util.Validator;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {
    public static List<Integer> inputPlayerNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String numbers = Console.readLine();
        Validator.validateInputNumbers(numbers);
        return StringUtil.convertStringToIntList(numbers);
    }
}
