package baseball.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    public List<Integer> readUserGuess() {
        String input = Console.readLine();
        return Arrays.stream(input.split("")).map(Integer::parseInt).collect(Collectors.toList());
    }
}
