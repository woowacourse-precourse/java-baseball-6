package baseball.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

public class BallsTest {

    private Balls answers;

    @BeforeEach
    void setUp() {
        answers = new Balls(List.of(4, 2, 5));
    }

    @Test
    void wrong_balls() {
        assertAll(
                () -> assertThatThrownBy(() -> new Balls(List.of(1, 2))).isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> new Balls(List.of(1, 2, 2))).isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Nested
    class compareOneBall {

        @Test
        void strike() {
            assertEquals(answers.play(new Ball(0, 4)), BallStatus.STRIKE);
        }

        @Test
        void ball() {
            assertEquals(answers.play(new Ball(1, 4)), BallStatus.BALL);
        }

        @Test
        void nothing() {
            assertEquals(answers.play(new Ball(0, 1)), BallStatus.NOTHING);
        }
    }
    
    @Nested
    class compareThreeBalls {

        @Test
        void play_3strike() {
            PlayResult result = answers.play(new Balls(List.of(4, 2, 5)));
            assertAll(
                    () -> assertEquals(result.getBall(), 0),
                    () -> assertEquals(result.getStrike(), 3),
                    () -> assertFalse(result.isContinue())
            );
        }

        @Test
        void play_1strike() {
            PlayResult result = answers.play(new Balls(List.of(1, 2, 3)));
            assertAll(
                    () -> assertEquals(result.getBall(), 0),
                    () -> assertEquals(result.getStrike(), 1)
            );
        }

        @Test
        void play_1ball1strike() {
            PlayResult result = answers.play(new Balls(List.of(4, 5, 6)));
            assertAll(
                    () -> assertEquals(result.getBall(), 1),
                    () -> assertEquals(result.getStrike(), 1)
            );
        }

        @Test
        void play_1ball() {
            PlayResult result = answers.play(new Balls(List.of(1, 3, 4)));
            assertAll(
                    () -> assertEquals(result.getBall(), 1),
                    () -> assertEquals(result.getStrike(), 0)
            );
        }

        @Test
        void play_nothing() {
            PlayResult result = answers.play(new Balls(List.of(7, 8, 9)));
            assertAll(
                    () -> assertEquals(result.getBall(), 0),
                    () -> assertEquals(result.getStrike(), 0)
            );
        }
    }
}
