package baseball.controller;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class GameControllerTest {

    @Test
    void 컴퓨터측_볼_생성(){
        GameController controller = new GameController();
        controller.start();
        Set<BallDto> computer = controller.getComputer();

        assertThat(computer.size()).isEqualTo(3);
    }

    @Test
    void 컴퓨터측_볼_내용_검증(){
        GameController controller = new GameController();
        controller.start();
        for (BallDto ballDto : controller.getComputer()) {
            assertThat(ballDto.getNumber()).isNotNull();
        }
    }
}