package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class Input {

    private static final String COMMAND_INPUT_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String NUMBERS_INPUT_MESSAGE = "숫자를 입력해주세요 : ";

    public String readCommand() {
        System.out.println(COMMAND_INPUT_MESSAGE);
        String input = read();
        validateNumberFormat(input);
        return input;
    }

    public List<Integer> readPlayerNumbers() {
        System.out.print(NUMBERS_INPUT_MESSAGE);
        return convertPlayerNumbers(read());
    }

    private List<Integer> convertPlayerNumbers(String input) {
        validateNumberFormat(input);
        return Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .toList();
    }

    private void validateNumberFormat(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private String read() {
        return Console.readLine();
    }
}
