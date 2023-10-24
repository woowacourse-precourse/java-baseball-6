package baseball.model;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GroundTest {

    @Test
    @DisplayName("스트라이크가 3개인 경우")
    void isThreeStrike() {
        // given
        Ground ground = Ground.of(3, 0);

        assertThat(ground.toString()).isEqualTo("3스트라이크");
    }

    @Test
    @DisplayName("볼이 3개인 경우")
    void isThreeBall() {
        // given
        Ground ground = Ground.of(0, 3);

        assertThat(ground.toString()).isEqualTo("3볼");
    }

    @Test
    @DisplayName("1스트라이크 2볼인 경우")
    void isOneStrikeTwoBall() {
        // given
        Ground ground = Ground.of(1, 2);

        assertThat(ground.toString()).isEqualTo("2볼 1스트라이크");
    }

    @Test
    @DisplayName("낫싱인 경우")
    void isNothing() {
        // given
        Ground ground = Ground.of(0, 0);

        assertThat(ground.toString()).isEqualTo("낫싱");
    }

}