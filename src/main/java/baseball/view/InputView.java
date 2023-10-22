package baseball.view;

import baseball.utils.Constant;
import baseball.validation.InputValidation;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static void firstStart() {
        System.out.println(Constant.FIRST_START);
    }

    public static String startInput() {
        System.out.println(Constant.INPUT_NUM);
        String inputNum = Console.readLine();
        InputValidation.verifyInputNum(inputNum);
        return inputNum;
    }

    public static String endInput() {
        System.out.println(Constant.IS_RESTART);
        return Console.readLine();
    }

}
