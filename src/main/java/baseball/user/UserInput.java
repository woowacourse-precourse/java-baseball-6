package baseball.user;

import static baseball.game.GameOutput.printRequestMessage;
import static baseball.validator.NumberValidator.validateAllDigits;
import static baseball.validator.NumberValidator.validateDuplicateNumber;
import static baseball.validator.NumberValidator.validateOneLength;
import static baseball.validator.NumberValidator.validateOneOrTwo;
import static baseball.validator.NumberValidator.validateThreeLength;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {

    public String readNumberString() {
        printRequestMessage();
        String numberString = Console.readLine();

        validateThreeLength(numberString);
        validateAllDigits(numberString);
        validateDuplicateNumber(Integer.parseInt(numberString));

        return numberString;
    }

    public String readOneOrTwo() {
        String numberString = Console.readLine();

        validateOneLength(numberString);
        validateOneOrTwo(numberString);
        validateAllDigits(numberString);

        return numberString;
    }

}
