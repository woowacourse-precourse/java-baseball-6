package baseball.view;

import baseball.utils.Message;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static baseball.utils.Message.*;
import static org.assertj.core.api.Assertions.assertThat;
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
            assertThat(output.toString().trim()).isEqualTo(PERFECT_MESSAGE.getMessage());
        }

        @Test
        @DisplayName("게임 재시작 문구가 출력되어야 한다.")
        public void 게임_재시작_문구가_출력되어야_한다() {
            OutputView.printRestartGame();
            assertThat(output.toString().trim()).isEqualTo(RESTART_GAME_MESSAGE.getMessage());
        }

        @Test
        @DisplayName("게임 종료 문구가 출력되어야 한다")
        public void 게임_종료_문구가_출력되어야_한다() {
            OutputView.printEndGame();
            assertThat(output.toString().trim()).isEqualTo(END_GAME_MESSAGE.getMessage());
        }

        @Test
        @DisplayName("낫싱이 출력되어야 한다")
        public void 낫싱이_출력되어야_한다() {
            OutputView.printNothing();
            assertThat(output.toString().trim()).isEqualTo(NOTHING.getMessage());
        }

        @DisplayName("스트라이크가 출력되어야 한다")
        @ParameterizedTest
        @ValueSource(ints = {1, 2, 3})
        public void 스트라이크가_출력되어야_한다(int strikeCount) {
            OutputView.printStrikeCount(strikeCount);
            assertThat(output.toString().trim()).isEqualTo(strikeCount + STRIKE.getMessage());
        }

        @DisplayName("볼이 출력되어야 한다")
        @ParameterizedTest
        @ValueSource(ints = {1, 2, 3})
        public void 볼이_출력되어야_한다(int ballCount) {
            OutputView.printBallCount(ballCount);
            assertThat(output.toString()).isEqualTo(ballCount + BALL.getMessage());
        }

        @Test
        @DisplayName("게임 시작 문구가 출력되어야 한다")
        public void 게임_시작_문구가_출력되어야_한다() {
            OutputView.printGameStartView();
            assertThat(output.toString().trim()).isEqualTo(START_GAME_MESSAGE.getMessage());
        }

        @Test
        @DisplayName("value가 0일 때 볼이 출력되면 안된다")
        public void value가_0일_때_볼이_출력되면_안된다() {
            OutputView.printBallCount(0);
            assertThat(output.toString().trim()).isEmpty();
        }

        @Test
        @DisplayName("value가 0일 때 스트라이크가 출력되면 안된다")
        public void value가_0일_때_스트라이크가_출력되면_안된다() {
            OutputView.printStrikeCount(0);
            assertThat(output.toString().trim()).isEmpty();
        }

        @Test
        @DisplayName("OutputView 내부에서 생성자를 호출 시 AssertionError가 발생해야 한다.")
        public void OutputView_내부에서_생성자를_호출_시_AssertionError가_발생해야_한다() throws Throwable {
            Constructor<OutputView> declaredConstructor = OutputView.class.getDeclaredConstructor();
            declaredConstructor.setAccessible(true);

            InvocationTargetException invocationTargetException = assertThrows(InvocationTargetException.class, declaredConstructor::newInstance);
            assertThat(invocationTargetException.getCause()).isInstanceOf(AssertionError.class);
        }
    }


}
