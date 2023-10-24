package baseball.view;

import baseball.validate.NumbersValidate;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {
    public static List<Integer> getPlayerGuessNumbers() {
        String givenInput = Console.readLine();
        NumbersValidate.isAllNumbers(givenInput);
        return Arrays.stream(givenInput.split("")).map(Integer::parseInt).toList();
    }
}
