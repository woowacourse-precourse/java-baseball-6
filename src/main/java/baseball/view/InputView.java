package baseball.view;

import baseball.util.ConsoleMessage;
import baseball.util.ExceptionMessage;
import baseball.util.Validator;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private static List<Integer> convertToIntegerList(String input) {
        return Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public List<Integer> readPlayerNumber() {
        printConsoleMessage(ConsoleMessage.INPUT_PLAYER_NUMBER.getMessage());
        String input = Validator.getValidatedPlayerNumber(Console.readLine());
        return convertToIntegerList(input);
    }

    public String readGameCommand() {
        System.out.println(ExceptionMessage.INVALID_GAME_COMMAND.getMessage());
        return Console.readLine();
    }

    private void printConsoleMessage(String message) {
        System.out.println(message);
    }
}
