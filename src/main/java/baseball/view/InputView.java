package baseball.view;

import baseball.service.ConsoleService;
import baseball.view.valid.InputValidator;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private static final String INPUT_NUMBER_MENT = "숫자를 입력해주세요 : ";
    private static final String NO_SPACE = "";
    public static final String INPUT_RESTART_OR_EXIT_MENT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private final ConsoleService consoleService;
    private final InputValidator inputValidator;

    public InputView(ConsoleService consoleService, InputValidator inputValidator) {
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
        System.out.println(INPUT_RESTART_OR_EXIT_MENT);
        String inputValue = consoleService.readLine();
        inputValidator.validRestartOrExit(inputValue);
        return Integer.parseInt(inputValue);
    }
}
