package baseball.util;

import baseball.Model.NumberModel;

import static baseball.util.Verify.verifyNumber;
import static baseball.util.Verify.verifyRestartValue;

public class InputNumber {

    public static NumberModel getInputNumber(String input){
        verifyNumber(input);

        int firstNumber = Integer.parseInt(String.valueOf(input.charAt(0)));
        int secondNumber = Integer.parseInt(String.valueOf(input.charAt(1)));
        int thirdNumber = Integer.parseInt(String.valueOf(input.charAt(2)));

        return new NumberModel(firstNumber,secondNumber,thirdNumber);
    }

    public static String getRestartNumber(String input){
        verifyRestartValue(input);
        return input;
    }

}
