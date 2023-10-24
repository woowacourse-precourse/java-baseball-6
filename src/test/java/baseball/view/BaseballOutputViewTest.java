package baseball.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import baseball.domain.Ball;
import baseball.domain.Score;
import baseball.domain.Strike;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class BaseballOutputViewTest {

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    public void setup() {
        System.setOut(new PrintStream(output));
    }

    @DisplayName("최초 게임 시작시 숫자 야구 게임을 시작합니다. 문구를 출력한다.")
    @Test
    void startGameTest() {
        BaseballOutputView baseballOutputView = new BaseballOutputView();
        baseballOutputView.startGame();
        assertThat(output.toString()).isEqualTo("숫자 야구 게임을 시작합니다.\n");
    }

    @DisplayName("3스트라이크시 3개의 숫자를 모두 맞히셨습니다! 게임종료 문구를 출력한다.")
    @Test
    void endGameTest() {
        BaseballOutputView baseballOutputView = new BaseballOutputView();
        baseballOutputView.endGame();
        assertThat(output.toString()).isEqualTo("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
    }

    @DisplayName("정답과 입력값을 비교하여 Score를 출력한다.")
    @ParameterizedTest
    @MethodSource("provideMatchResultTestArguments")
    void matchResultTest(Score score, String matchResult, boolean isStrikeOut) {
        BaseballOutputView baseballOutputView = new BaseballOutputView();
        baseballOutputView.matchResult(score);
        boolean isFullCount = score.isStrikeOut();
        assertThat(output.toString()).isEqualTo(matchResult);
        assertThat(isFullCount).isEqualTo(isStrikeOut);
    }

    static Stream<Arguments> provideMatchResultTestArguments() {
        return Stream.of(
                arguments(Score.from(Ball.from(1), Strike.from(1)), "1볼 1스트라이크\n", false),
                arguments(Score.from(Ball.from(1), Strike.from(0)), "1볼\n", false),
                arguments(Score.from(Ball.from(2), Strike.from(0)), "2볼\n", false),
                arguments(Score.from(Ball.from(0), Strike.from(1)), "1스트라이크\n", false),
                arguments(Score.from(Ball.from(0), Strike.from(0)), "낫싱\n", false),
                arguments(Score.from(Ball.from(0), Strike.from(3)), "3스트라이크\n", true)
        );
    }
}
