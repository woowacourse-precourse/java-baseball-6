package baseball;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputDevice {

    private final ConsoleService consoleService;
    private final InputValidator inputValidator;

    public InputDevice(ConsoleService consoleService, InputValidator inputValidator) {
        this.consoleService = consoleService;
        this.inputValidator = inputValidator;
    }

    public List<Integer> inputTryNumber() {
        System.out.println("숫자를 입력해주세요 : ");
        String inputValue = consoleService.readLine();
        inputValidator.valid(inputValue);
        return Arrays.stream(inputValue.split("")).map(Integer::parseInt).collect(Collectors.toList());
    }

    public int restartOrExit() {
        String inputValue = consoleService.readLine();
        inputValidator.validRestartOrExit(inputValue);
        return Integer.parseInt(inputValue);
    }
}
