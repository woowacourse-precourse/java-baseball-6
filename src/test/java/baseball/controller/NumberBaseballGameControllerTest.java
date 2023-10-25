package baseball.controller;

import static org.junit.jupiter.api.Assertions.assertThrows;

import baseball.model.Game;
import baseball.view.GameView;
import baseball.view.NumberBaseballGameView;
import java.io.ByteArrayInputStream;
import java.util.function.Supplier;
import org.junit.jupiter.api.Test;

class NumberBaseballGameControllerTest {

    private final GameView gameView = new NumberBaseballGameView("src/main/resources/messages/messages.properties");
    private final Supplier<Game> mockSupplier = () -> null;

    @Test
    void InputNot1Or2() {
        final byte[] buf = "3\n".getBytes();
        System.setIn(new ByteArrayInputStream(buf));
        NumberBaseballGameController controller = new NumberBaseballGameController(mockSupplier, gameView);
        assertThrows(IllegalArgumentException.class, controller::checkResume);
    }
}