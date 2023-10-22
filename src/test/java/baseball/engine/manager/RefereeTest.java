package baseball.engine.manager;

import baseball.engine.dto.BaseBallStatus;
import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RefereeTest {
    Referee referee = new Referee();

    @DisplayName("isAllStrike() 메소드가 참이고 '3스트라이크' 문자열을 반환한다.")
    @ParameterizedTest(name = "{index}: userNumbers: {0}, randomNumbers: {1}")
    @MethodSource("get3StrikeSources")
    void testGetStrikeAndBall_3Strike(List<Integer> userNumbers, List<Integer> randomNumbers,
                                      ExpectedMessage expectedResult) {
        //given
        //when
        BaseBallStatus baseBallStatus = referee.getStrikeAndBallCount(userNumbers, randomNumbers);
        //then
        Assertions.assertThat(baseBallStatus.isAllStrike()).isTrue();
        Assertions.assertThat(baseBallStatus.getResult()).contains(expectedResult.getMessage());
    }

    @DisplayName("isAllStrike() 메소드가 거짓이고 기대하는 문자열을 반환한다.")
    @ParameterizedTest(name = "{index}: userNumbers: {0}, randomNumbers: {1}")
    @MethodSource("getStrikeAndBallSources")
    void testGetStrikeAndBall(List<Integer> userNumbers, List<Integer> randomNumbers, ExpectedMessage expectedResult) {
        //given
        //when
        BaseBallStatus baseBallStatus = referee.getStrikeAndBallCount(userNumbers, randomNumbers);
        //then
        Assertions.assertThat(baseBallStatus.isAllStrike()).isFalse();
        Assertions.assertThat(baseBallStatus.getResult()).contains(expectedResult.getMessage());
    }

    @DisplayName("isAllStrike() 메소드가 거짓이고 '낫싱' 문자열을 반환한다.")
    @ParameterizedTest(name = "{index}: userNumbers: {0}, randomNumbers: {1}")
    @MethodSource("getNothingSources")
    void testGetStrikeAndBall_Nothing(List<Integer> userNumbers, List<Integer> randomNumbers, ExpectedMessage expectedResult) {
        //given
        //when
        BaseBallStatus baseBallStatus = referee.getStrikeAndBallCount(userNumbers, randomNumbers);
        //then
        Assertions.assertThat(baseBallStatus.isAllStrike()).isFalse();
        Assertions.assertThat(baseBallStatus.getResult()).contains(expectedResult.getMessage());
    }


    static Stream<Arguments> get3StrikeSources() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3), List.of(1, 2, 3), ExpectedMessage.TRHEE_STRIKE),
                Arguments.of(List.of(3, 6, 9), List.of(3, 6, 9), ExpectedMessage.TRHEE_STRIKE));
    }

    static Stream<Arguments> getStrikeAndBallSources() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3), List.of(1, 2, 5), ExpectedMessage.TWO_STRIKE),
                Arguments.of(List.of(3, 6, 9), List.of(3, 1, 2), ExpectedMessage.ONE_STRIKE),
                Arguments.of(List.of(3, 6, 9), List.of(9, 3, 6), ExpectedMessage.TRHEE_BALL),
                Arguments.of(List.of(3, 6, 9), List.of(6, 3, 1), ExpectedMessage.TWO_BALL),
                Arguments.of(List.of(3, 6, 9), List.of(1, 3, 2), ExpectedMessage.ONE_BALL),
                Arguments.of(List.of(3, 6, 9), List.of(6, 3, 9), ExpectedMessage.TWO_BALL_ONE_STRIKE),
                Arguments.of(List.of(3, 6, 9), List.of(1, 3, 9), ExpectedMessage.ONE_BALL_ONE_STRIKE)
        );
    }

    static Stream<Arguments> getNothingSources() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3), List.of(4, 5, 6), ExpectedMessage.NOTTHING),
                Arguments.of(List.of(3, 6, 9), List.of(1, 4, 7), ExpectedMessage.NOTTHING));
    }

    private enum ExpectedMessage {

        TRHEE_STRIKE("3스트라이크"),
        TWO_STRIKE("2스트라이크"),
        ONE_STRIKE("1스트라이크"),
        TRHEE_BALL("3볼"),
        TWO_BALL("2볼"),
        ONE_BALL("1볼"),
        TWO_BALL_ONE_STRIKE("2볼 1스트라이크"),
        ONE_BALL_ONE_STRIKE("1볼 1스트라이크"),
        NOTTHING("낫싱");

        private String message;

        ExpectedMessage(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}