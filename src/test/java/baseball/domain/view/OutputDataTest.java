package baseball.domain.view;

import baseball.domain.model.BallCount;
import org.junit.jupiter.api.BeforeEach;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class OutputDataTest {
    EnumMap<BallCount, Integer> result;

    @BeforeEach
    void setUp() {
        result = Arrays.stream(BallCount.values())
                .collect(Collectors.toMap(value -> value, count -> 0, (a, b) -> b,
                        () -> new EnumMap<>(BallCount.class)));
    }

}