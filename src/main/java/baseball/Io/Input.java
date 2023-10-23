package baseball.Io;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Input {
    public static List<Integer> UserNumbers() {
        List<Integer> numbers = new ArrayList<>();
        String input = Console.readLine();
        for (int i = 0; i < input.length(); i++) {
            numbers.add(Integer.parseInt(input.substring(i, i + 1)));
        }
        return numbers;
    }
}
