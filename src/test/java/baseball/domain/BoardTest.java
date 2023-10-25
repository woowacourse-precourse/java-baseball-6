package baseball.domain;

import static baseball.domain.BallStatus.BALL;
import static baseball.domain.BallStatus.NOTHING;
import static baseball.domain.BallStatus.STRIKE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BoardTest {

    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board();
    }

    @ParameterizedTest
    @CsvSource(value = {"0,false", "1,true", "2,false"})
    void 정답_검증(int matchScore, boolean expected) {
        // given
        board.scoring(STRIKE);

        // when
        boolean result = board.isMatch(matchScore);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void 스코어_리셋_검증() {
        // given
        board.scoring(BALL);
        board.scoring(STRIKE);
        board.scoring(NOTHING);

        // when
        board.reset();

        // then
        assertAll(
            () -> assertThat(board.getScore(BALL)).isEqualTo(0),
            () -> assertThat(board.getScore(STRIKE)).isEqualTo(0),
            () -> assertThat(board.getScore(NOTHING)).isEqualTo(0)
        );
    }
}
