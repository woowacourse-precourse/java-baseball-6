package baseball.convertorTest;


import domain.ball.Ball;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import util.convertor.IntegerListToBallListConvertor;

public class IntegerListToBallListConvertorTest {

    @ParameterizedTest
    @MethodSource("provideIntegerListAndExpectedList")
    @DisplayName("숫자 리스트 볼 리스트로 변환 검증")
    void convertIntegerListToBALLListTest(List<Integer> value, List<Ball> expectBallList) {
        //given
        List<Ball> ballList = IntegerListToBallListConvertor.convert(value);

        //when
        int count = (int) IntStream.range(0, ballList.size())
                .filter(i -> ballList.get(i).equals(expectBallList.get(i)))
                .count();

        //then
        Assertions.assertThat(count).isEqualTo(ballList.size());
        Assertions.assertThat(ballList).isEqualTo(expectBallList);
    }

    static Stream<Arguments> provideIntegerListAndExpectedList() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3),
                        Arrays.asList(
                                new Ball(1, 1),
                                new Ball(2, 2),
                                new Ball(3, 3))),
                Arguments.of(Arrays.asList(4, 5, 6),
                        Arrays.asList(
                                new Ball(4, 1),
                                new Ball(5, 2),
                                new Ball(6, 3))),
                Arguments.of(Arrays.asList(7, 8, 9),
                        Arrays.asList(
                                new Ball(7, 1),
                                new Ball(8, 2),
                                new Ball(9, 3)))
        );
    }
}
