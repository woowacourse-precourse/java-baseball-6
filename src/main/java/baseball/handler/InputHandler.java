package baseball.handler;

import baseball.Exception.InputValidator;
import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    private final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private final String RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private final InputValidator inputValidator;
    public InputHandler() {
        inputValidator = new InputValidator();
    }

    public String getNumbers() {
        System.out.print(INPUT_MESSAGE);
        String input = Console.readLine();
        inputValidator.doValidate(input);
        return input;
    }

    public String getCommand() {
        System.out.println(RESTART_MESSAGE);
        String command = Console.readLine();
        inputValidator.validateCommand(command);
        return command;
    }
}
