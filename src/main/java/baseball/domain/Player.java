package baseball.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Player {

    public Player() {
    }

    public List<Integer> getNumber(String number) {
        return convertToIntegerList(number);
    }

    public List<Integer> convertToIntegerList(String number) {
        return Arrays.stream(number.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
