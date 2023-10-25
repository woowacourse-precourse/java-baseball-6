package baseball.utility;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringUtilsTest {

    private static final int BALL_COUNT = 3;

    @Test
    void convertStringToIntegers_성공() {
        // given
        String string = IntStream.rangeClosed(1, BALL_COUNT)
                .mapToObj(i -> String.valueOf(i))
                .collect(Collectors.joining());

        // when
        List<Integer> integers = StringUtils.convertStringToIntegerList(string);

        // then
        IntStream.range(0, BALL_COUNT)
                .forEach(i -> {
                    int value = integers.get(i);
                    int expectedValue = i + 1;

                    Assertions.assertEquals(value, expectedValue);
                });
    }
}
