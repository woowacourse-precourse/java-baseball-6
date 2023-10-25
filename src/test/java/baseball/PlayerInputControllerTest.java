package baseball;

import static org.junit.jupiter.api.Assertions.assertThrows;

import baseball.controller.PlayerInputController;
import baseball.controller.Validator;
import java.util.ArrayList;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerInputControllerTest {

    Validator validator = new Validator();
    PlayerInputController playerInputCon = new PlayerInputController(validator);

    @Test
    void 사용자_입력처리_테스트() {
        String playerFirstInput = "3 45";
        ArrayList<Integer> playerInput = playerInputCon.handlePlayerInput(playerFirstInput);

        Assertions.assertThat(playerInput).containsExactly(3, 4, 5);
    }

    @Test
    void 사용자_입력처리_검증기_정상작동_테스트() {
        String playerFirstInput = "3 4 a";
        assertThrows(IllegalArgumentException.class, () ->
                playerInputCon.handlePlayerInput(playerFirstInput));
    }
}
