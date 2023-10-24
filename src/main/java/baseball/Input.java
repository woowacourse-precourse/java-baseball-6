package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class Input {

    public List<Integer> readPlayerNumber() {
        String input = Console.readLine();
        Validator.validatePlayerNumber(input);
        return convertToList(input);
    }

    public GameCommand readGameCommand() {
        String input = Console.readLine();
        Validator.validateGameCommand(input);
        return GameCommand.from(input);
    }

    private List<Integer> convertToList(String input) {
        return Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .toList();
    }

}
