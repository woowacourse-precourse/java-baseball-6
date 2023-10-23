package baseball.view;

import baseball.utils.Message;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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
            org.assertj.core.api.Assertions.assertThat(output.toString().trim()).isEqualTo(Message.PERFECT_MESSAGE.getMessage());
        }
    }


}
