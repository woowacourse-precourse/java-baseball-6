package baseball.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {
    public List<Integer> readPlayerNumber() {
        String input = Console.readLine();
        return Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .toList();
    }
}
