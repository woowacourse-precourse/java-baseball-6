package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import domain.Ball;
import domain.NumbersGenerator;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import util.convertor.IntegerListToBallListConvertor;
import util.validator.BallSizeValidator;

public class BallGeneratorTest {

    @ParameterizedTest
    @DisplayName("볼 리스트 생성 검증")
    @MethodSource("provideIntegerList")
    void GenerateBallTest(List<Integer> numbers) {
        //when
        List<Ball> balls = IntegerListToBallListConvertor.convert(numbers);
        //then
        assertThat(balls)
                .allSatisfy(ball -> assertThat(ball)
                        .isInstanceOf(Ball.class));
    }



    private static Stream<List<Integer>> provideIntegerList() {
        return Stream.of(
                List.of(1, 2, 3),
                List.of(4, 5, 6),
                List.of(7, 8, 9)
        );
    }


}
