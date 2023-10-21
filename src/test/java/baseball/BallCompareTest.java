package baseball;

import domain.Ball;
import domain.BallComparator;
import domain.Balls;
import domain.BaseballResultDto;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class BallCompareTest {

    @ParameterizedTest
    @DisplayName("N 스트라이크 N볼 검증")
    @MethodSource("ProvideCompareTestCases")
    public void BallCompareTest(Balls userBalls, Balls computerBalls, BaseballResultDto resultDto) {
        //given
        BallComparator ballComparator = new BallComparator();

        //when
        BaseballResultDto baseballResultDto = ballComparator.compareStatus(userBalls,
                computerBalls);
        //then
        Assertions.assertThat(baseballResultDto.getStrike()).isEqualTo(resultDto.getStrike());
        Assertions.assertThat(baseballResultDto.getBall()).isEqualTo(resultDto.getBall());
    }

    static Stream<Arguments> ProvideCompareTestCases() {
        List<Arguments> testCases = new ArrayList<>();

        List<Ball> ballList = new ArrayList<>();
        ballList.add(new Ball(5, 1));
        ballList.add(new Ball(7, 2));
        ballList.add(new Ball(6, 3));
        Balls balls = new Balls(ballList);
        BaseballResultDto resultDto = new BaseballResultDto(3, 0);
        testCases.add(Arguments.of(balls, balls, resultDto));

        List<Ball> ballList1 = new ArrayList<>();
        ballList1.add(new Ball(6, 1));
        ballList1.add(new Ball(7, 2));
        ballList1.add(new Ball(8, 3));
        Balls balls1 = new Balls(ballList1);
        List<Ball> ballList2 = new ArrayList<>();
        ballList2.add(new Ball(6, 1));
        ballList2.add(new Ball(7, 2));
        ballList2.add(new Ball(5, 3));
        Balls balls2 = new Balls(ballList2);
        BaseballResultDto resultDto1 = new BaseballResultDto(2, 0);
        testCases.add(Arguments.of(balls1, balls2, resultDto1));

        BaseballResultDto resultDto2 = new BaseballResultDto(1, 2);
        testCases.add(Arguments.of(balls, balls2, resultDto2));

        return testCases.stream();
    }

}
