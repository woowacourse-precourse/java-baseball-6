package baseball.controller;

import static org.junit.jupiter.api.Assertions.assertThrows;

import baseball.model.NumberBaseballGame;
import baseball.view.GameView;
import baseball.view.NumberBaseballGameView;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Test;

class NumberBaseballGameControllerTest {

    GameView gameView = new NumberBaseballGameView("src/main/resources/messages/messages.properties");

    @Test
    void InputNot1Or2() {
        final byte[] buf = "3\n".getBytes();
        System.setIn(new ByteArrayInputStream(buf));
        NumberBaseballGameController controller = new NumberBaseballGameController(NumberBaseballGame.class, gameView);
        assertThrows(IllegalArgumentException.class, controller::checkResume);
    }
}