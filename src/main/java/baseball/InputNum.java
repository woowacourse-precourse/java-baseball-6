package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InputNum {

    public List<Integer> getInputNum() {
        String input = Console.readLine();

        if (input.length() != 3 || !input.matches("[1-9]+")) {
            throw new IllegalArgumentException();
        }

        List<Integer> inputList = new ArrayList<>(3);
        for (int i = 0; i < 3; i++) {
            inputList.add(input.charAt(i) - '0');
        }

        if (inputList.stream().distinct().collect(Collectors.toList()).size() != inputList.size()) {
            throw new IllegalArgumentException();
        }
        return inputList;
    }
}
