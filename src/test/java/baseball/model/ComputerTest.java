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
    @MethodSource("inValidSizeData")
    void validateNumberSize(List<Integer> inValidNumbers){
        assertThrows(IllegalArgumentException.class,() -> new Computer(inValidNumbers));
    }

    @DisplayName("컴퓨터는 숫자를 1부터 9까지만 가질 수 있다")
    @ParameterizedTest
    @MethodSource("inValidRangeData")
    void validateNumberRange(List<Integer> inValidNumbers){
        assertThrows(IllegalArgumentException.class,() -> new Computer(inValidNumbers));
    }

    @DisplayName("컴퓨터는 중복된 숫자를 가질 수 없다")
    @ParameterizedTest
    @MethodSource("inValidDuplicateData")
    void validateNumberDuplicate(List<Integer> inValidNumbers){
        assertThrows(IllegalArgumentException.class,() -> new Computer(inValidNumbers));
    }


    static Stream<Arguments> inValidSizeData() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4)),
                Arguments.of(Arrays.asList(1, 2))
        );
    }
    static Stream<Arguments> inValidRangeData() {
        return Stream.of(
                Arguments.of(Arrays.asList(-1, 2, 33)),
                Arguments.of(Arrays.asList(0, 0, 0)),
                Arguments.of(Arrays.asList(11, 22, 33))
        );
    }
    static Stream<Arguments> inValidDuplicateData() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 1)),
                Arguments.of(Arrays.asList(2, 2, 2)),
                Arguments.of(Arrays.asList(5, 3, 3))
        );
    }
}