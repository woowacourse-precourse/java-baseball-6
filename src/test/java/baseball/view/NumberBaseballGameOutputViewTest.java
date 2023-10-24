package baseball.view;

import static baseball.view.NumberBaseballGameOutputView.START_GAME_MESSAGE;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class NumberBaseballGameOutputViewTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void 시작_메시지가_올바르게_출력되는지_테스트() {
        NumberBaseballGameOutputView outputView = new NumberBaseballGameOutputView();
        String gameName = "숫자 야구";
        outputView.printStartGameMessage(gameName);
        assertEquals(gameName + START_GAME_MESSAGE + "\r\n", outContent.toString());
    }

    @Test
    void 숫자_입력을_요청하는_메시지가_올바르게_출력되는지_테스트() {
        NumberBaseballGameOutputView outputView = new NumberBaseballGameOutputView();
        String printMessage = "숫자를 입력해주세요.";
        outputView.printNumberInputRequest();
        assertEquals(printMessage + "\r\n", outContent.toString());
    }

}