package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static baseball.GameException.isInRange;
import static baseball.GameException.isNotDuplicate;

public class User {
    public List<Integer> input() {
        List<Integer> userNum = new ArrayList<>();
        Message.input();
        String input = Console.readLine();

        return userNum = isCorrectInput(input);
    }

    private List<Integer> isCorrectInput(String input) {
        if (!isValid(input)) {
            throw new IllegalArgumentException();
        }
        return stringToIntegerList(input);
    }

    private List<Integer> stringToIntegerList(String input) {
        return Arrays.stream(input.split("")).map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private boolean isValid(String input) {
        return input.length() == 3 && isInRange(input) && isNotDuplicate(input);
    }
}
