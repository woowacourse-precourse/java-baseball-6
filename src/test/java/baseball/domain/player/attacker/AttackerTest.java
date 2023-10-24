package baseball.domain.player.attacker;

import static org.junit.jupiter.api.Assertions.assertThrows;

import baseball.domain.player.value.Ball;
import baseball.domain.player.value.Balls;
import baseball.exception.rutime.NotInitializeBallException;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AttackerTest {

    private final Balls BALLS_SOURCE =
        new Balls(List.of(Ball.of(1L), Ball.of(2L), Ball.of(3L)));
    @Test
    @DisplayName("공격자의 공을 초기화하지 않으면 예외가 발생한다.")
    void needInitialize() {
        // given
        Attacker attacker = new ConsoleAttacker();

        // when

        // then
        assertThrows(NotInitializeBallException.class, attacker::attack);
    }

    @Test
    @DisplayName("공격자는 공격할 수 있다")
    void getBalls() {
        // given
        Attacker attacker = new ConsoleAttacker();
        attacker.initialize(BALLS_SOURCE);

        // when
        Balls balls = attacker.attack();

        // then
        Assertions.assertEquals(BALLS_SOURCE, balls);
    }
}