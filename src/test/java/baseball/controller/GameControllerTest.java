package baseball.controller;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class GameControllerTest {

    @Test
    void 컴퓨터측_볼_생성(){
        GameController controller = new GameController();
        controller.createComputerBall();
        List<BallDto> computer = controller.getComputer();
        assertThat(computer.size()).isEqualTo(3);
    }

    @Test
    void 컴퓨터측_볼_검증(){
        GameController controller = new GameController();
        controller.createComputerBall();
        List<BallDto> computer = controller.getComputer();
        for (BallDto ballDto : computer) {
            assertThat(ballDto.getNumber()).isNotNull();
        }
    }

    @Test
    void 유저측_볼_생성(){
        GameController controller = new GameController();
        controller.createUserBall("251");
        List<BallDto> user = controller.getUser();

        assertThat(user.size()).isEqualTo(3);
    }

    @Test
    void 유저측_볼_내용_검증(){
        GameController controller = new GameController();
        controller.createUserBall("251");
        for (BallDto ballDto : controller.getUser()) {
            assertThat(ballDto.getNumber()).isNotNull();
        }
    }
}