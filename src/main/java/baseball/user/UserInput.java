package baseball.user;

import static baseball.output.GameOutput.printRequestMessage;
import static baseball.validator.NumberValidator.validateAllDigits;
import static baseball.validator.NumberValidator.validateDuplicateNumber;
import static baseball.validator.NumberValidator.validateRequiredLength;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {

    public String inputNumberString() {
        printRequestMessage();
        String numberString = Console.readLine();

        validateRequiredLength(numberString);
        validateAllDigits(numberString);
        validateDuplicateNumber(Integer.parseInt(numberString));

        return numberString;
    }

}
