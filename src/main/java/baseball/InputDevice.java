package baseball;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputDevice {

    private static final String INPUT_NUMBER_MENT = "숫자를 입력해주세요 : ";
    private static final String NO_SPACE = "";
    private final ConsoleService consoleService;
    private final InputValidator inputValidator;

    public InputDevice(ConsoleService consoleService, InputValidator inputValidator) {
        this.consoleService = consoleService;
        this.inputValidator = inputValidator;
    }

    public List<Integer> inputTryNumber() {
        System.out.println(INPUT_NUMBER_MENT);
        String inputValue = consoleService.readLine();
        inputValidator.validTryNumber(inputValue);
        return Arrays.stream(inputValue.split(NO_SPACE)).map(Integer::parseInt).collect(Collectors.toList());
    }

    public int restartOrExit() {
        String inputValue = consoleService.readLine();
        inputValidator.validRestartOrExit(inputValue);
        return Integer.parseInt(inputValue);
    }
}
