package baseball.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest {

    private final OutputView outputView = new OutputView();
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @DisplayName("게임 시작을 알리는 메시지를 출력한다.")
    @Test
    void printGameStart() {
        // given

        // when
        outputView.printGameStart();

        // then
        String expectedOutput = "숫자 야구 게임을 시작합니다.\n";
        assertThat(outContent.toString()).isEqualTo(expectedOutput);
    }

    @DisplayName("게임 한판 당 결과 메시지를 출력한다.")
    @Test
    void printResultWithBall() {
        // given

        // when
        outputView.printResult(2, 0);

        // then
        String expectedOutput = "2볼\n";
        assertThat(outContent.toString()).isEqualTo(expectedOutput);
    }

    @DisplayName("게임 한판 당 결과 메시지를 출력한다.")
    @Test
    void printResultWithStrike() {
        // given

        // when
        outputView.printResult(0, 2);

        // then
        String expectedOutput = "2스트라이크\n";
        assertThat(outContent.toString()).isEqualTo(expectedOutput);
    }


    @DisplayName("게임 한판 당 결과 메시지를 출력한다.")
    @Test
    void printResult() {
        // given

        // when
        outputView.printResult(1, 2);

        // then
        String expectedOutput = "1볼 2스트라이크\n";
        assertThat(outContent.toString()).isEqualTo(expectedOutput);
    }

    @DisplayName("게임 한판 당 결과 메시지를 출력한다.")
    @Test
    void printResultWithNothing() {
        // given

        // when
        outputView.printResult(0, 0);

        // then
        String expectedOutput = "낫싱\n";
        assertThat(outContent.toString()).isEqualTo(expectedOutput);
    }

    @DisplayName("게임 시작을 알리는 메시지를 출력한다.")
    @Test
    void printGameOver() {
        // given

        // when
        outputView.printGameOver();

        // then
        String expectedOutput = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n";
        assertThat(outContent.toString()).isEqualTo(expectedOutput);
    }
}