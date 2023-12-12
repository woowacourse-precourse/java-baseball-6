package baseball.view;

import baseball.domain.entity.Numbers;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {

    public static Numbers inputNumbers() {
        char[] numberArray = Console.readLine().toCharArray();
        return Numbers.of(mapCharaerToNumber(numberArray));
    }

    private static List<Integer> mapCharaerToNumber(char[] numberArray) {
        return IntStream.range(0, numberArray.length)
            .map(i -> Character.getNumericValue(numberArray[i]))
            .boxed()
            .collect(Collectors.toList());
    }

    public static String inputRestart() {
        return Console.readLine();
    }

}
