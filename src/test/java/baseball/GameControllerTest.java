package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class GameControllerTest {

    @Test
    void 스트라이크_볼_로직_테스트() {
        GameController gameController = new GameController();

        //3스트라이크
        assertThat(gameController.logicTest("123", "123")).isEqualTo("3스트라이크");

        //1스트라이크
        assertThat(gameController.logicTest("123", "453")).isEqualTo("1스트라이크");

        //1볼
        assertThat(gameController.logicTest("123", "435")).isEqualTo("1볼");

        //1볼 1스트라이크
        assertThat(gameController.logicTest("123", "134")).isEqualTo("1볼 1스트라이크");

        //낫싱
        assertThat(gameController.logicTest("123", "456")).isEqualTo("낫싱");
    }
}