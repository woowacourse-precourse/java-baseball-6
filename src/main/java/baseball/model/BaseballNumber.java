package baseball.model;

import java.util.*;
import java.util.stream.Collectors;

public class BaseballNumber {
    private List<Integer> baseballNumber;

    public BaseballNumber(List<Integer> baseballNumber) {
        this.baseballNumber = baseballNumber;
    }

    public List<Integer> getBaseballNumberList() {
        return baseballNumber;
    }
}
