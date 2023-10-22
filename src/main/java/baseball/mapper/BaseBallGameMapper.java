package baseball.mapper;

import java.util.Arrays;
import java.util.List;

public class BaseBallGameMapper {
    public List<Integer> toList(String input) {
        return Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .toList();
    }

    public int toInt(String input) {
        return Integer.parseInt(input);
    }
}

