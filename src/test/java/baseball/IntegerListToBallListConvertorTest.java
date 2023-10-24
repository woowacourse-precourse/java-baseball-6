package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import domain.Ball;
import domain.Balls;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import util.convertor.IntegerListToBallListConvertor;
import util.convertor.StringToIntegerListConvertor;

public class IntegerListToBallListConvertorTest {

    @ParameterizedTest
    @MethodSource("provideIntegerListAndExpectedList")
    @DisplayName("숫자 리스트 볼 리스트로 변환 검증")
    void convertIntegerListToBALLListTest(List<Integer> value) {
        //when
        List<Ball> ballList = IntegerListToBallListConvertor.convert(value);

        //then
        assertThat(ballList)
                .allSatisfy(ball -> assertThat(ball)
                        .isInstanceOf(Ball.class));
        ;
    }

    static Stream<Arguments> provideIntegerListAndExpectedList() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3)),
                Arguments.of(Arrays.asList(4, 5, 6)),
                Arguments.of(Arrays.asList(7, 8, 9))
        );
    }
}
