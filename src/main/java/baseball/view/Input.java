package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class Input {

    public String readCommand() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = read();
        validateNumberFormat(input);
        return input;
    }

    public List<Integer> readPlayerNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
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
