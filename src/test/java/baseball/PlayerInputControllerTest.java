package baseball;

import baseball.Controller.PlayerInputController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayerInputControllerTest {
    PlayerInputController playerInputCon = new PlayerInputController();

    @Test
    void 사용자_입력처리_테스트(){
        String playerFirstInput = "3 45";
        ArrayList<Integer> playerInput = playerInputCon.handlePlayerInput(playerFirstInput);

        Assertions.assertThat(playerInput).containsExactly(3,4,5);
    }

    @Test
    void 사용자_입력처리_검증기_정상작동_테스트(){
        String playerFirstInput = "3 4 a";
        assertThrows(IllegalArgumentException.class, () ->
            playerInputCon.handlePlayerInput(playerFirstInput));
    }
}
