package baseball.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {

    public static List<Integer> inputNumbers() {
        char[] numberArray = Console.readLine().toCharArray();
        return mapCharaterToInteger(numberArray);
    }

    private static List<Integer> mapCharaterToInteger(char[] numberArray) {
        return IntStream.range(0, numberArray.length)
            .map(i -> Character.getNumericValue(numberArray[i]))
            .boxed()
            .collect(Collectors.toList());
    }
}
