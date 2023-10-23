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

    public static int inputRestartOrExitNumber() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String number = Console.readLine();
        Validator.validateRestartOrExitNumber(number);
        return StringUtil.convertStringToInt(number);
    }
}
