package baseball.Io;

import baseball.validation.InputValidation;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Input {
    public static List<Integer> Numbers() {
        String input = Console.readLine();
        InputValidation.Number(input);

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            numbers.add(Integer.parseInt(input.substring(i, i + 1)));
        }
        return numbers;
    }
}
