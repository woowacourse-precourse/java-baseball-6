package baseball.domain;

import baseball.validator.InputValidation;

import java.util.ArrayList;
import java.util.List;

public class PlayerNumbersManager {

    public static void checkPlayerNumberAndCreate(String inputNumber) {
        InputValidation.isNull(inputNumber);
        InputValidation.isNumber(inputNumber);
        InputValidation.isThreeLetter(inputNumber);
        InputValidation.isNumberScope(inputNumber);
        InputValidation.isDuplicateNumber(inputNumber);
    }
}
