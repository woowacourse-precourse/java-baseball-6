package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Player {

    public List<Integer> inputNumbers() {
        List<Integer> input = Arrays.stream(Console.readLine().split("")).mapToInt(Integer::parseInt).boxed().collect(
                Collectors.toList());
        return input;
    }

    public boolean inputRestartOrEnd() {
        String input = Console.readLine();
        if (input.equals("1")) {
            return true;
        }
        if (input.equals("2")) {
            return false;
        }
        return false;
    }
}