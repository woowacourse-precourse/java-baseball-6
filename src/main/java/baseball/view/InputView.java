package baseball.view;

import baseball.NumericValidator;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    public static List<Integer> readNumbers() {
        final String input = readLine(ConsoleMessage.INPUT_NUMBER);
        return Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .toList();
    }

    public static int readOptionNumber() {
        return Integer.parseInt(readLine(ConsoleMessage.INPUT_GAME_OPTION));
    }

    private static String readLine(final ConsoleMessage message) {
        System.out.print(message.message);
        final String input = Console.readLine();
        NumericValidator.validate(input);
        return input;
    }

    private enum ConsoleMessage {
        INPUT_NUMBER("숫자를 입력해주세요 : "),
        INPUT_GAME_OPTION("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        private final String message;

        ConsoleMessage(final String message) {
            this.message = message;
        }
    }
}
