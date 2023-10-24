package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {

    private final FormValidation formValidation = new FormValidation();

    public static Input getInstance() {
        return new Input();
    }

    public List<Integer> inputBallNumbers() {
        String input = input();

        formValidation.isOnlyNumbers(input);
        formValidation.isOnlyThreeLength(input);

        String[] inputToArray = input.split("");
        return Arrays.stream(inputToArray)
                .map(Integer::parseInt)
                .collect(Collectors.toUnmodifiableList());
    }

    public int inputContinueGame() {
        String input = input();
        formValidation.isOnlyNumbers(input);
        formValidation.isOnlyOneOrTwo(input);

        return Integer.parseInt(input);
    }

    private String input() {
        return Console.readLine();
    }
}
