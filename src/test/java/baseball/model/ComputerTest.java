package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {

    @DisplayName("컴퓨터는 숫자를 3개만 가질 수 있다")
    @ParameterizedTest
    @MethodSource("generateData")
    void validateNumberSize(List<Integer> inValidNumbers){
        assertThrows(IllegalArgumentException.class,() -> new Computer(inValidNumbers));
    }

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4)),
                Arguments.of(Arrays.asList(1, 2))
        );
    }
}