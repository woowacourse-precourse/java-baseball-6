package baseball;

import camp.nextstep.edu.missionutils.Console;

public class InputReader {
    private static InputReader instance;
    private InputValidator inputValidator;

    private InputReader() {
        inputValidator = InputValidator.getInstance();
    }

    public static InputReader getInstance() {
        if (instance == null) {
            instance = new InputReader();
        }
        return instance;
    }

    // get 3-digit number
    public int getGuessInput(){
        int inputNumber = Integer.parseInt(Console.readLine());
        inputValidator.validateThreeDigit(inputNumber);
        return inputNumber;
    }

    public int getFinishedGameInput(){
        int inputNumber = Integer.parseInt(Console.readLine());
        inputValidator.validateEndInput(inputNumber);
        return inputNumber;
    }
}
