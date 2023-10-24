package baseball.modules.score;

import static baseball.modules.score.BaseBallScoreType.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

import baseball.modules.player.Computer;
import baseball.modules.player.Human;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@Nested
@DisplayName("[Baseball Score]")
class BaseballScoreTest {

    @ParameterizedTest
    @MethodSource("score3Strike")
    @DisplayName("스코어 테스트 - 3 스트라이크")
    public void scoreTest_3Strike(final String computer, final String user) {
        assertThat(new BaseballScore()
                .calculate(new Computer(computer), new Human(user))
                .getScore()
                .get(STRIKE)
        ).isEqualTo(3);
    }

    static Stream<Arguments> score3Strike() {
        return Stream.of(
                arguments("123", "123"),
                arguments("124", "124"),
                arguments("924", "924")
        );
    }

    @ParameterizedTest
    @MethodSource("score2Strike")
    @DisplayName("스코어 테스트 - 2 스트라이크")
    public void scoreTest_2Strike(final String computer, final String user) {

        Map<? extends ScoreType, Integer> score = new BaseballScore()
                .calculate(new Computer(computer), new Human(user))
                .getScore();
        assertThat(score.get(STRIKE)).isEqualTo(2);
        assertThat(score.get(BALL)).isEqualTo(0);
    }

    static Stream<Arguments> score2Strike() {
        return Stream.of(
                arguments("123", "124"),
                arguments("124", "154"),
                arguments("924", "324")
        );
    }

    @ParameterizedTest
    @MethodSource("score1Strike")
    @DisplayName("스코어 테스트 - 1 스트라이크")
    public void scoreTest_1Strike(final String computer, final String user) {
        Map<? extends ScoreType, Integer> score = new BaseballScore()
                .calculate(new Computer(computer), new Human(user))
                .getScore();
        assertThat(score.get(STRIKE)).isEqualTo(1);
        assertThat(score.get(BALL)).isEqualTo(0);
    }

    static Stream<Arguments> score1Strike() {
        return Stream.of(
                arguments("123", "154"),
                arguments("124", "723"),
                arguments("924", "834")
        );
    }

    @ParameterizedTest
    @MethodSource("score1Strike2Ball")
    @DisplayName("스코어 테스트 - 1 스트라이크 2 볼")
    public void scoreTest_1Strike2Ball(final String computer, final String user) {
        Map<? extends ScoreType, Integer> score = new BaseballScore()
                .calculate(new Computer(computer), new Human(user))
                .getScore();
        assertThat(score.get(STRIKE)).isEqualTo(1);
        assertThat(score.get(BALL)).isEqualTo(2);
    }

    static Stream<Arguments> score1Strike2Ball() {
        return Stream.of(
                arguments("123", "132"),
                arguments("124", "421"),
                arguments("924", "294")
        );
    }

    @ParameterizedTest
    @MethodSource("score1Strike1Ball")
    @DisplayName("스코어 테스트 - 1 스트라이크 1 볼")
    public void scoreTest_1Strike1Ball(final String computer, final String user) {
        Map<? extends ScoreType, Integer> score = new BaseballScore()
                .calculate(new Computer(computer), new Human(user))
                .getScore();
        assertThat(score.get(STRIKE)).isEqualTo(1);
        assertThat(score.get(BALL)).isEqualTo(1);
    }

    static Stream<Arguments> score1Strike1Ball() {
        return Stream.of(
                arguments("123", "134"),
                arguments("124", "521"),
                arguments("924", "284")
        );
    }

    @ParameterizedTest
    @MethodSource("score0Strike1Ball")
    @DisplayName("스코어 테스트 - 0 스트라이크 1 볼")
    public void scoreTest_0Strike1Ball(final String computer, final String user) {
        Map<? extends ScoreType, Integer> score = new BaseballScore()
                .calculate(new Computer(computer), new Human(user))
                .getScore();
        assertThat(score.get(STRIKE)).isEqualTo(0);
        assertThat(score.get(BALL)).isEqualTo(1);
    }

    static Stream<Arguments> score0Strike1Ball() {
        return Stream.of(
                arguments("123", "451"),
                arguments("124", "256"),
                arguments("924", "748")
        );
    }

    @ParameterizedTest
    @MethodSource("score0Strike2Ball")
    @DisplayName("스코어 테스트 - 0 스트라이크 2 볼")
    public void scoreTest_0Strike2Ball(final String computer, final String user) {
        Map<? extends ScoreType, Integer> score = new BaseballScore()
                .calculate(new Computer(computer), new Human(user))
                .getScore();
        assertThat(score.get(STRIKE)).isEqualTo(0);
        assertThat(score.get(BALL)).isEqualTo(2);
    }

    static Stream<Arguments> score0Strike2Ball() {
        return Stream.of(
                arguments("123", "432"),
                arguments("124", "413"),
                arguments("924", "248")
        );
    }


    @ParameterizedTest
    @MethodSource("score0Strike3Ball")
    @DisplayName("스코어 테스트 - 0 스트라이크 3 볼")
    public void scoreTest_0Strike3Ball(final String computer, final String user) {
        Map<? extends ScoreType, Integer> score = new BaseballScore()
                .calculate(new Computer(computer), new Human(user))
                .getScore();
        assertThat(score.get(STRIKE)).isEqualTo(0);
        assertThat(score.get(BALL)).isEqualTo(3);
    }

    static Stream<Arguments> score0Strike3Ball() {
        return Stream.of(
                arguments("123", "312"),
                arguments("124", "241"),
                arguments("924", "249")
        );
    }

    @ParameterizedTest
    @MethodSource("score0Strike0Ball")
    @DisplayName("스코어 테스트 - 0 스트라이크 0 볼")
    public void scoreTest_0Strike0Ball(final String computer, final String user) {
        Map<? extends ScoreType, Integer> score = new BaseballScore()
                .calculate(new Computer(computer), new Human(user))
                .getScore();
        assertThat(score.get(STRIKE)).isEqualTo(0);
        assertThat(score.get(BALL)).isEqualTo(0);
    }

    static Stream<Arguments> score0Strike0Ball() {
        return Stream.of(
                arguments("123", "456"),
                arguments("124", "789"),
                arguments("924", "813")
        );
    }

}