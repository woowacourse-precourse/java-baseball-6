package baseball.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;

import baseball.controller.GameController;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameViewTest {

    final GameView gameView = new GameView(new GameController());

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
    public void 게임시작_시작안내문구를_출력한다() {
        gameView.start();
        assertEquals("숫자 야구 게임을 시작합니다.", outputStreamCaptor.toString().trim());
    }

}