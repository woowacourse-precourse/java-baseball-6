package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class Input {

    public List<Integer> readPlayerNumber() {
        String input = Console.readLine();
        return convertToList(input);
    }
}
