package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

import static baseball.Validator.validateInput;

public class User {

    private GameNumber number;

    public void pickNumber() {
        String input = Console.readLine();
        validateInput(input);
        List<Integer> numberPick = Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .toList();
        number = new GameNumber(numberPick);
    }

    public GameNumber getNumber() {
        return number;
    }

}
