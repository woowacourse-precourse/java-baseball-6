package baseball.view;

import java.util.Arrays;
import java.util.List;

public class InputConvertor {

    public List<Integer> convertIntegerList(String input) {
        return Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .toList();
    }
}
