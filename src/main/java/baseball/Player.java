package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Player {

    public List<Integer> inputNumbers() throws IllegalArgumentException {
        List<String> input = Arrays.stream(Console.readLine().split("")).toList();
        if (input.size() != input.stream().distinct().count()) {
            throw new IllegalArgumentException();
        }
        if (input.size() != 3) {
            throw new IllegalArgumentException();
        }
        try {
            return input.stream().map(Integer::parseInt).collect(Collectors.toList());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }

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