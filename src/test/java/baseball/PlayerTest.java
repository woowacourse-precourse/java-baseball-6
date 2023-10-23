package baseball;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    static Player player;

    @BeforeAll
    static void setup() {
        player = new Player();
    }

    @Test
    void 입력_테스트() {
        String tempInput = "123";
        System.setIn(new ByteArrayInputStream(tempInput.getBytes()));
        String resultInput = player.getInput();
        assertTrue(resultInput.equals(tempInput));
    }
}
