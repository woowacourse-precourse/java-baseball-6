package baseball.view;

import baseball.utils.Message;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static baseball.utils.Message.*;
import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest {

    @Nested
    @DisplayName("출력 값 테스트")
    class printTest {

        private final ByteArrayOutputStream output = new ByteArrayOutputStream();

        @BeforeEach
        public void setUp() {
            System.setOut(new PrintStream(output));
        }

        @AfterEach
        public void reset() {
            System.setOut(System.out);
            output.reset();
        }

        @Test
        @DisplayName("3스트라이크가 출력되어야 한다.")
        public void Three_스트라이크가_출력되어야_한다() {
            OutputView.printPerfect();
            org.assertj.core.api.Assertions.assertThat(output.toString().trim()).isEqualTo(PERFECT_MESSAGE.getMessage());
        }

        @Test
        @DisplayName("게임 재시작 문구가 출력되어야 한다.")
        public void 게임_재시작_문구가_출력되어야_한다() {
            OutputView.printRestartGame();
            org.assertj.core.api.Assertions.assertThat(output.toString().trim()).isEqualTo(RESTART_GAME_MESSAGE.getMessage());
        }

        @Test
        @DisplayName("게임 종료 문구가 출력되어야 한다")
        public void 게임_종료_문구가_출력되어야_한다() {
            OutputView.printEndGame();
            org.assertj.core.api.Assertions.assertThat(output.toString().trim()).isEqualTo(END_GAME_MESSAGE.getMessage());
        }

        @Test
        @DisplayName("낫싱이 출력되어야 한다")
        public void 낫싱이_출력되어야_한다() {
            OutputView.printNothing();
            org.assertj.core.api.Assertions.assertThat(output.toString().trim()).isEqualTo(NOTHING.getMessage());
        }

        @DisplayName("스트라이크가 출력되어야 한다")
        @ParameterizedTest
        @ValueSource(ints = {1, 2, 3})
        public void 스트라이크가_출력되어야_한다(int strikeCount) {
            OutputView.printStrikeCount(strikeCount);
            org.assertj.core.api.Assertions.assertThat(output.toString().trim()).isEqualTo(strikeCount + STRIKE.getMessage());
        }

        @DisplayName("볼이 출력되어야 한다")
        @ParameterizedTest
        @ValueSource(ints = {1, 2, 3})
        public void 볼이_출력되어야_한다(int ballCount) {
            OutputView.printBallCount(ballCount);
            org.assertj.core.api.Assertions.assertThat(output.toString()).isEqualTo(ballCount + BALL.getMessage());
        }



    }


}
