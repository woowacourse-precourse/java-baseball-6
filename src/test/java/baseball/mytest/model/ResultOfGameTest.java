package baseball.mytest.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class ResultOfGameTest {
    ResultOfGame resultOfGame = new ResultOfGame();

    @Test
    void 스트라이크만_있을_경우() {
        assertThat(resultOfGame.result(1, 0)).isEqualTo("1스트라이크");
    }

    @Test
    void 볼만_있을_경우() {
        assertThat(resultOfGame.result(0, 2)).isEqualTo("2볼");
    }

    @Test
    void 스트라이크와_볼_모두_있을_경우() {
        assertThat(resultOfGame.result(1, 2)).isEqualTo("2볼 1스트라이크");
    }

    @Test
    void 낫싱일_경우() {
        assertThat(resultOfGame.result(0, 0)).isEqualTo("낫싱");
    }

    @Test
    void 정답일_경우() {
        assertThat(resultOfGame.result(3, 0)).isEqualTo("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
