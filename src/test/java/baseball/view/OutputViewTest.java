package baseball.view;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import baseball.domain.GameResult;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class OutputViewTest {
    private final PrintStream originalOut = System.out;
    private ByteArrayOutputStream out;

    @BeforeEach
    void setUp(){
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @AfterEach
    void tearDown(){
        System.setOut(originalOut);
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("results")
    void 판정_결과를_형식에_맞게_출력한다(String name, GameResult result, String expected) {
        new OutputView().printResult(result);

        assertThat(out.toString().trim()).isEqualTo(expected);
    }

    static Stream<Arguments> results() {
        return Stream.of(
                Arguments.of("볼만 있는 경우", new GameResult(0, 2), "2볼"),
                Arguments.of("스트라이크만 있는 경우", new GameResult(1, 0), "1스트라이크"),
                Arguments.of("볼과 스트라이크가 모두 있는 경우", new GameResult(1, 1), "1볼 1스트라이크"),
                Arguments.of("3볼 2스트라이크인 경우", new GameResult(2, 3), "3볼 2스트라이크"),
                Arguments.of("아무것도 없는 경우", new GameResult(0, 0), "낫싱")
        );
    }
}
