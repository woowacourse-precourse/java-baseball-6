package baseball.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class OutputViewTest {

    private OutputView outputView;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
        outputView = new OutputView();
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    @DisplayName("printStartGame() 메서드는 숫자 야구 게임을 시작한다는 문구 출력한다.")
    void testPrintStartGame() {

        // when
        outputView.printStartGame();

        // then
        assertThat(outContent.toString()).hasToString("숫자 야구 게임을 시작합니다.\n");
    }

    @Test
    @DisplayName("printInputNumber() 메서드는 숫자를 입력해주세요 문구 출력한다.")
    void testPrintInputNumber() {

        // when
        outputView.printInputNumber();

        // then
        assertThat(outContent.toString()).hasToString("숫자를 입력해주세요 : ");
    }

    @Test
    @DisplayName("1볼, 2스트라이크 시 '1볼 2스트라이크'를 출력한다")
    void testPrintGameProgress() {

        // when
        outputView.printGameProgress(2, 1);

        // then
        assertThat(outContent.toString()).hasToString("1볼 2스트라이크\n");
    }

    @Test
    @DisplayName("3스트라이크 시 '3스트라이크'를 출력한다")
    void testThreeStrikeTest() {

        // when
        outputView.printGameProgress(3, 0);

        // then
        assertThat(outContent.toString()).hasToString("3스트라이크\n");
    }

    @Test
    @DisplayName("0볼 0스트라이크 시 '낫싱'을 출력한다")
    void nothingTest() {

        // when
        outputView.printGameProgress(0, 0);

        // then
        assertThat(outContent.toString()).hasToString("낫싱\n");
    }

    @Test
    @DisplayName("printDecideGame() 메서드는 3개의 숫자를 모두 맞히셨습니다! 게임 종료 문구 출력한다.")
    void testPrintDecideGame() {

        // when
        outputView.printDecideGame();

        // then
        assertThat(outContent.toString()).hasToString("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
    }

    @Test
    @DisplayName("printRestartGame() 메서드는 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요 문구 출력한다.")
    void testPrintRestartGame() {

        // when
        outputView.printRestartGame();

        // then
        assertThat(outContent.toString()).hasToString("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
    }
}
