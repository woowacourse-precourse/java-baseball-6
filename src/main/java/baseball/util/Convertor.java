package baseball.util;

import baseball.domain.RetryCommand;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Convertor {

    public static List<Integer> convertStringToList(String input) {
        List<Integer> list = new ArrayList<>();
        String[] split = input.split("");
        for (String s : split) {
            int digit = Integer.parseInt(s);
            list.add(digit);
        }
        return list;
    }

    public static RetryCommand findByInput(String input) {
        return Arrays.stream(RetryCommand.values())
                .filter(it -> it.getNumber().equals(input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("1, 2만 입력 가능합니다."));
    }
}
