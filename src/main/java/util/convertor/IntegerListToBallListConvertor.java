package util.convertor;

import domain.Ball;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public  class IntegerListToBallListConvertor {

    public static List<Ball> convert(List<Integer> numbers) {
        List<Ball> balls = IntStream.range(0, 3)
                .mapToObj(i -> {
                    int value = numbers.get(i);
                    int index = i + 1;
                    return new Ball(value,index);
                })
                .collect(Collectors.toList());
        return balls;
    }
}
