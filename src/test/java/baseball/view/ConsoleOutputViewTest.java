package baseball.view;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.model.GameResult;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ConsoleOutputViewTest {
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    void setupStream() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    void restoreStream() {
        System.setOut(System.out);
        output.reset();
    }

    @ParameterizedTest
    @DisplayName("게임 결과 출력 메시지 확인 테스트")
    @MethodSource("gameResultAndExpectMessage")
    void calculateGameResultTest(GameResult gameResult, String expectMessage) {
        ConsoleOutputView consoleOutputView = new ConsoleOutputView();
        consoleOutputView.showGameResult(gameResult);
        assertThat(output.toString()).isEqualTo(expectMessage);
    }

    public static Stream<Arguments> gameResultAndExpectMessage() {
        return Stream.of(
                Arguments.of(new GameResult(3, 0, 0), "낫싱\n"),
                Arguments.of(new GameResult(3, 0, 1), "1볼\n"),
                Arguments.of(new GameResult(3, 0, 2), "2볼\n"),
                Arguments.of(new GameResult(3, 0, 3), "3볼\n"),
                Arguments.of(new GameResult(3, 1, 0), "1스트라이크\n"),
                Arguments.of(new GameResult(3, 1, 1), "1볼 1스트라이크\n"),
                Arguments.of(new GameResult(3, 1, 2), "2볼 1스트라이크\n"),
                Arguments.of(new GameResult(3, 2, 0), "2스트라이크\n"),
                Arguments.of(new GameResult(3, 3, 0), "3스트라이크\n")

        );
    }
}