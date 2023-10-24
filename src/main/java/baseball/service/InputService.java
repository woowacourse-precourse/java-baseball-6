package baseball.service;

import baseball.exception.InvalidNumberInputException;
import baseball.exception.InvalidRestartInputException;
import baseball.validator.InputValidator;
import camp.nextstep.edu.missionutils.Console;

public class InputService {
    private final InputValidator validator;

    public InputService() {
        this.validator = new InputValidator();
    }

    public String getNumber(int size, int start, int end) {
        String input = Console.readLine();
        if (!validator.isValidNumberInput(input, start, end, size)) {
            throw new InvalidNumberInputException();
        }
        return input;
    }

    public boolean restart(String input, int restart, int exit) {
        if (!validator.isValidRestartOrExit(input, restart, exit)) {
            throw new InvalidRestartInputException();
        }
        return Integer.parseInt(input) == restart;
    }
}