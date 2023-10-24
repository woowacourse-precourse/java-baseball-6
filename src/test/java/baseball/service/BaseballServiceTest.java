package baseball.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mockStatic;

import baseball.model.Baseball;
import baseball.model.BaseballGameResult;
import baseball.model.BaseballGameResultType;
import baseball.model.BaseballNumber;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.MockedStatic;

class BaseballServiceTest {

    private static MockedStatic<Randoms> randoms;
    private final BaseballService baseballService = new BaseballService();

    @BeforeAll
    static void beforeAll() {
        randoms = mockStatic(Randoms.class);
    }

    @AfterAll
    static void afterAll() {
        randoms.close();
    }

    @Nested
    @DisplayName("1-9까지 임의의 서로 다른 세 숫자를 생성할 시")
    class createAnswerBaseball {

        @DisplayName("성공적으로 생성한다.")
        @Test
        void success() {
            //given
            given(Randoms.pickNumberInRange(anyInt(), anyInt())).willReturn(5, 1, 1, 2, 2);

            //when
            Baseball answerBaseball = baseballService.createAnswerBaseball();

            //then
            assertThat(answerBaseball).isNotNull();
            Assertions.assertThat(answerBaseball.getBaseballNumbers())
                    .extracting(BaseballNumber::getNumber)
                    .containsExactly(5, 1, 2);
        }
    }

    @Nested
    @DisplayName("숫자 야구의 결과를 계산할 시")
    class calculateResult {

        static Stream<Arguments> getSuccessTestArgument() {
            return Stream.of(
                    Arguments.of(Baseball.from(List.of(1, 2, 3)), Baseball.from(List.of(1, 2, 3)), 0, 3),
                    Arguments.of(Baseball.from(List.of(1, 2, 4)), Baseball.from(List.of(1, 2, 3)), 0, 2),
                    Arguments.of(Baseball.from(List.of(1, 3, 2)), Baseball.from(List.of(1, 2, 3)), 2, 1),
                    Arguments.of(Baseball.from(List.of(4, 5, 6)), Baseball.from(List.of(1, 2, 3)), 0, 0)
            );
        }

        @DisplayName("성공적으로 결과를 반환한다.")
        @MethodSource("getSuccessTestArgument")
        @ParameterizedTest(name = "정답: {0} 추측: {1} ball: {2}, strike: {3}")
        void success(Baseball answer, Baseball guess, int ballCount, int strikeCount) {
            //given
            //when
            BaseballGameResult result = baseballService.calculateResult(answer, guess);

            //then
            assertThat(result).isNotNull();
            assertThat(result.getCount(BaseballGameResultType.BALL)).isEqualTo(ballCount);
            assertThat(result.getCount(BaseballGameResultType.STRIKE)).isEqualTo(strikeCount);
        }
    }
}