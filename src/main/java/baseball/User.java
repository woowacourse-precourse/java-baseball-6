package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

import static baseball.Validator.validateInput;

public class User {

    private List<Integer> numbers;

    public void pickNumber() {
        String input = Console.readLine();
        validateInput(input);
        numbers = Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .toList();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
