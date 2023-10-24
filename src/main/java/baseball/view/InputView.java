package baseball.view;

import baseball.util.ConsoleMessage;
import baseball.util.Validator;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    public List<Integer> readPlayerNumber() {
        printConsoleMessage(ConsoleMessage.INPUT_PLAYER_NUMBER.getMessage());
        String input = Validator.getValidatedPlayerNumber(Console.readLine());
        return Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .toList();
    }

    private void printConsoleMessage(String message) {
        System.out.println(message);
    }
}
