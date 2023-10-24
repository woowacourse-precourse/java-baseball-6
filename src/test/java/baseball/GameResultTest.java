package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameResultTest {

    @Test
    void 게임_결과_레코드_테스트() {
        // given
        GameResult gameResult1 = new GameResult(3, 0);
        GameResult gameResult2 = new GameResult(2, 1);

        // when
        int game1Strike = gameResult1.strikes();
        int game1Ball = gameResult1.balls();

        // then
        assertThat(game1Strike).isEqualTo(3);
        assertThat(game1Ball).isEqualTo(0);
        assertThat(gameResult1.isGameEnd()).isEqualTo(Boolean.TRUE);
        assertThat(gameResult2.isGameEnd()).isEqualTo(Boolean.FALSE);

        // equals() & hashcode() 테스트
        assertThat(gameResult1).isNotEqualTo(gameResult2);
    }
}