package baseball;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Number {
    private List<Integer> digitList;

    public Number(List<Integer> number) {
        this.digitList = number;
    }

    public Number(String input) {
        digitList = Stream.of(input.split("")).map(Integer::parseInt).collect(Collectors.toList());
    }
}
