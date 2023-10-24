package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {
    public static Input getInstance() {
        return new Input();
    }

    public List<Integer> inputBallNumbers() {
        String input = input();
        String[] inputToArray = input.split("");
        return Arrays.stream(inputToArray)
                .map(Integer::parseInt)
                .collect(Collectors.toUnmodifiableList());
    }

    private String input() {
        return Console.readLine();
    }
}
