package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Input {

    private static final String COMMAND_INPUT_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String NUMBERS_INPUT_MESSAGE = "숫자를 입력해주세요 : ";

    private final InputValidator validator = new InputValidator();
    private final InputConvertor convertor = new InputConvertor();

    public String readCommand() {
        System.out.println(COMMAND_INPUT_MESSAGE);
        String input = read();
        validator.validateNumberFormat(input);
        return input;
    }

    public List<Integer> readPlayerNumbers() {
        System.out.print(NUMBERS_INPUT_MESSAGE);
        String input = read();
        validator.validateNumberFormat(input);
        return convertor.convertPlayerNumbers(input);
    }

    private String read() {
        return Console.readLine();
    }
}
