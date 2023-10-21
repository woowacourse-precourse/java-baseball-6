package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class BaseBallUITest {

    final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    final PrintStream standardOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void 숫자_야구게임을시작하는_문구가_출력되야한다() {
        final String expect = "숫자 야구 게임을 시작합니다.";
        BaseBallUI baseBallUI = new BaseBallUI();
        baseBallUI.gameStart();
        Assertions.assertThat(outputStreamCaptor.toString().trim()).isEqualTo(expect);
    }

}