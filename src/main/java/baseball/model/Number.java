package baseball.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Number {
    private final List<Integer> data;

    private Number(String inputData) {
        data = new ArrayList<>(3);
        String[] dataList = inputData.split("");
        Arrays.stream(dataList)
                .map(Integer::valueOf)
                .forEach(data::add);
    }

    private Number(List<Integer> generateData) {
        data = generateData;
    }

    public static Number of(String inputData) {
        return new Number(inputData);
    }

    public static Number of(List<Integer> generateData) {
        return new Number(generateData);
    }

    public List<Integer> getData() {
        return data;
    }
}
