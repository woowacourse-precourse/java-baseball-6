package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameResultTest {
    @Test
    @DisplayName("퍼펙트 게임 True 테스트")
    void perfectGameTrueTest() {
        assertThat(new GameResult(3, 3, 0)
                .isPerfectGame())
                .isTrue();
    }

    @Test
    @DisplayName("퍼펙트 게임 False 테스트")
    void perfectGameFalseTest() {
        assertThat(new GameResult(3, 2, 0)
                .isPerfectGame())
                .isFalse();
    }

    @Test
    @DisplayName("유효하지 않은 게임 결과")
    void invalidGameResultTest() {
        assertThrows(IllegalArgumentException.class, () ->
                new GameResult(3, 2, 2));
    }
}