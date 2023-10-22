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

}