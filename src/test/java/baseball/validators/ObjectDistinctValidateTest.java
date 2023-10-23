package baseball.validators;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ObjectDistinctValidateTest {

    @Test
    void Object_List_미중복_허용() {
        // when
        List<Object> integers = Stream.of(1, 2, 3)
                .collect(Collectors.toList());

        // then
        Assertions.assertDoesNotThrow(() -> {
            ObjectDistinctValidator.validateDistinct(integers);
        });
    }

    @Test
    void Object_List_중복_불허() {
        // when
        List<Object> integers = Stream.of(1, 2, 2)
                .collect(Collectors.toList());

        // then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            ObjectDistinctValidator.validateDistinct(integers);
        });
    }

}
