package baseball.validator;

import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ListValidatorsTest {

    private final int SIZE = 3;

    @Test
    void List_미중복_크기일치_허용() {
        // when
        List<Integer> integers = IntStream.range(0, SIZE)
                .boxed()
                .toList();

        // then
        Assertions.assertDoesNotThrow(() -> {
            ListValidators.validateDistinct(integers);
            ListValidators.validateSize(integers, SIZE);
        });
    }

    @Test
    void List_중복_크기불일치_불허() {
        // when
        List<Integer> integers = IntStream.range(0, SIZE + 1)
                .boxed()
                .toList();

        // then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            ListValidators.validateDistinct(integers);
            ListValidators.validateSize(integers, SIZE);
        });
    }

}
