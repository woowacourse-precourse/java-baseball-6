package baseball.controller;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class GameControllerTest {

    @Test
    void 유저측_볼_생성(){
        GameController controller = new GameController();
        controller.gameProcess("251");
        Set<BallDto> user = controller.getUser();

        assertThat(user.size()).isEqualTo(3);
    }

    @Test
    void 유저측_볼_내용_검증(){
        GameController controller = new GameController();
        controller.gameProcess("251");
        for (BallDto ballDto : controller.getUser()) {
            assertThat(ballDto.getNumber()).isNotNull();
        }
    }
}