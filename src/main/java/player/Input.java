package player;

import camp.nextstep.edu.missionutils.Console;
import computer.Error;
import constant.GuideMessageConstant;

public class Input {
    public static String inputNumber = "";

    public static void inputNumber() {
        System.out.println(GuideMessageConstant.NUMBER_INPUT_MESSAGE);
        inputNumber = Console.readLine();
        Error.validateThreeDigitNumberError(inputNumber);
    }

}
