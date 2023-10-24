package baseball.dto;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.BallStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GuessResultTest {

    @DisplayName("최초 생성 시 빈 상태로 생성된다")
    @Test
    void empty() {
        GuessResult guessResult = GuessResult.empty();

        assertThat(guessResult.count(BallStatus.STRIKE)).isZero();
        assertThat(guessResult.count(BallStatus.BALL)).isZero();
    }

    @DisplayName("특정 BallStatus에 대한 값이 없는 경우 0이 반환된다")
    @Test
    void count() {
        GuessResult guessResult = GuessResult.empty();

        assertThat(guessResult.count(BallStatus.STRIKE)).isZero();
        assertThat(guessResult.count(BallStatus.BALL)).isZero();
    }

    @DisplayName("add시 주어진 BallStatus에 대한 count 값이 1 증가한다")
    @Test
    void add() {
        GuessResult guessResult = GuessResult.empty();

        guessResult.add(BallStatus.STRIKE);
        guessResult.add(BallStatus.STRIKE);
        guessResult.add(BallStatus.BALL);

        assertThat(guessResult.count(BallStatus.STRIKE)).isEqualTo(2);
        assertThat(guessResult.count(BallStatus.BALL)).isEqualTo(1);
    }
}
