package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static baseball.Const.*;
import static baseball.Validator.validateInput;

public class User {

    private List<Integer> numbers;

    // TODO: 유저가 할 동작
    /**
     * 1. 숫자를 뽑는다.
     */

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
