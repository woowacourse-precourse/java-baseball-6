package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OutputTest {
    private OutputStream outputStream;
    OutputView outputView = new OutputView();
    GameScore gameScore;

    @BeforeEach
    void initStream() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void 스트라이크_3개() {
        gameScore = new GameScore(3, 0);
        outputView.printResult(gameScore);
        assertThat(outputStream.toString()).contains("3스트라이크");
    }

    @Test
    void 적중_X() {
        gameScore = new GameScore(0, 0);
        outputView.printResult(gameScore);
        assertThat(outputStream.toString()).contains("낫싱");
    }

    @Test
    void 그외의_경우() {
        gameScore = new GameScore(2, 1);
        outputView.printResult(gameScore);
        assertThat(outputStream.toString()).contains("1볼 2스트라이크");
    }
}
