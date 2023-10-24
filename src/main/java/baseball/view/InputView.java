package baseball.view;

import static baseball.utils.Constant.FIRST_START;
import static baseball.utils.Constant.INPUT_NUM;
import static baseball.utils.Constant.IS_RESTART;

import baseball.validation.InputValidation;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static void firstStart() {
        System.out.println(FIRST_START);
    }

    public static String getUserNumber() {
        System.out.println(INPUT_NUM);
        String inputNum = Console.readLine();
        InputValidation.verifyInputNum(inputNum);
        return inputNum;
    }

    public static String askToPlayAgain() {
        System.out.println(IS_RESTART);
        return Console.readLine();
    }

}
