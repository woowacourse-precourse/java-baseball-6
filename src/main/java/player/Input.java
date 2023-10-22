package player;

import camp.nextstep.edu.missionutils.Console;
import constant.GuideMessageConstant;

public class Input {
    public static int inputNumber = 0;

    public static void inputNumber() {
        System.out.println(GuideMessageConstant.NUMBER_INPUT_MESSAGE);
        try {
            inputNumber = Integer.parseInt(Console.readLine());
            if (inputNumber < 100 || inputNumber > 999) {
                throw new IllegalArgumentException(GuideMessageConstant.ERROR_ENTER_THREE_NUMBER);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.exit(1); // 비정상 종료
        }

    }

}
