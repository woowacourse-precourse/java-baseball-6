package baseball.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import baseball.domain.dto.GameResultDTO;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputViewTest {
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @DisplayName("1볼 1스트라이크")
    @Test
    void print_BallAndStrike() {
        // given
        GameResultDTO gameResultDTO = new GameResultDTO(1, 1);

        // when
        OutputView outputView = new OutputView();
        outputView.printGameResult(gameResultDTO);

        // then
        assertEquals("1볼 1스트라이크", output.toString().trim());
    }

    @DisplayName("2볼")
    @Test
    void print_Ball() {
        // given
        GameResultDTO gameResultDTO = new GameResultDTO(2, 0);

        // when
        OutputView outputView = new OutputView();
        outputView.printGameResult(gameResultDTO);

        // then
        assertEquals("2볼", output.toString().trim());
    }

    @DisplayName("1스트라이크")
    @Test
    void print_Strike() {
        // given
        GameResultDTO gameResultDTO = new GameResultDTO(0, 1);

        // when
        OutputView outputView = new OutputView();
        outputView.printGameResult(gameResultDTO);

        // then
        assertEquals("1스트라이크", output.toString().trim());
    }

    @DisplayName("낫싱")
    @Test
    void print_Nothing() {
        // given
        GameResultDTO gameResultDTO = new GameResultDTO(0, 0);

        // when
        OutputView outputView = new OutputView();
        outputView.printGameResult(gameResultDTO);

        // then
        assertEquals("낫싱", output.toString().trim());
    }
}