package player;

import constant.GuideMessageConstant;
import constant.StringConstant;

public class Error {


    public static void validateThreeDigitNumberError(String input) {
        try {
            int inputNumber = Integer.parseInt(input);
            if (inputNumber < 100 || inputNumber > 999) {
                throw new IllegalArgumentException(GuideMessageConstant.ERROR_ENTER_THREE_NUMBER);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(GuideMessageConstant.ERROR_NOT_TEXT_ENTER_NUMBER);
        }
    }


    public static void restartCommandError(String restarting_Game) {
        if (!restarting_Game.equals(StringConstant.CONTINUE) && !restarting_Game.equals(StringConstant.FINISH)) {
            throw new IllegalArgumentException(GuideMessageConstant.ERROR_ONE_OR_TWO_ENTER);
        }
    }


}
