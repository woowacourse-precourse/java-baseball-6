package baseball.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.*;

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
}