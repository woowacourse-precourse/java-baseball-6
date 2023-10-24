package baseball;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private Validator validator = new Validator();

    public String inputNumbers() {
        String readNumbers = Console.readLine();
        checkNumbersValidation(readNumbers);
        return readNumbers;
    }

    public String inputRestartOrEndGame() {
        String readNumber = Console.readLine();
        checkNumberValidation(readNumber);
        return readNumber;
    }

    private void checkNumberValidation(String readNumber) {
        validator.validateInputNumberOfRestartAndEnd(readNumber);
    }

    private void checkNumbersValidation(String readNumbers) {
        validator.validateInputNumbersSize(readNumbers);
        validator.validateInputNumbersDuplicated(readNumbers);
        validator.validateInputNumberIsNumeric(readNumbers);
    }

}
