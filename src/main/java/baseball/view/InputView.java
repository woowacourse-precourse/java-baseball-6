package baseball.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public static List<Integer> inputNumber() {
        String numberString = Console.readLine();
        String[] splitNumberString = numberString.split("");
        return mapToInteger(splitNumberString);
    }

    private static List<Integer> mapToInteger(String[] splitNumberString)
            throws IllegalArgumentException {
        return Arrays.stream(splitNumberString)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int inputRestartGame() {
        String restart = Console.readLine();
        return Integer.parseInt(restart);
    }
}
