package baseball.domain;

import baseball.domain.validators.InputValidator;
import camp.nextstep.edu.missionutils.Console;

public class InputOutputHandler {

    private final InputValidator inputValidator;

    public InputOutputHandler(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public String inputText() {
        return Console.readLine();
    }

    public String inputUniqueNumbers(int numberLength) {
        String input = inputText();
        inputValidator.validateUniqueNumbers(numberLength, input);

        return input;
    }

    public int inputOneNumber() {
        String input = inputText();
        inputValidator.validateSingleNumber(input);

        return Integer.parseInt(input);
    }

    public void printText(String text) {
        System.out.print(text);
    }

    public void printlnText(String text) {
        System.out.println(text);
    }


}
