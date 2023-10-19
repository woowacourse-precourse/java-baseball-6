package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class Player {
    public List<Integer> readNumber() {
        String read = Console.readLine();
        List<Integer> numbers = new ArrayList<>();

        for (char c: read.toCharArray()) {
            numbers.add(Character.getNumericValue(c));
        }
        return numbers;
    }
}
