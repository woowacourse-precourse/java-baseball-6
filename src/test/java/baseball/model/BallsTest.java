package baseball.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BallsTest {

    private Balls answer;

    @BeforeEach
    void setUp() {
        answer = new Balls(List.of(4, 2, 5));
    }

    @Test
    void wrong_balls() {
        assertAll(
                () -> assertThatThrownBy(() -> new Balls(List.of(1, 2))).isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> new Balls(List.of(1, 2, 2))).isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void strike() {
        assertEquals(answer.play(new Ball(0, 4)), BallStatus.STRIKE);
    }

    @Test
    void ball() {
        assertEquals(answer.play(new Ball(1, 4)), BallStatus.BALL);
    }

    @Test
    void nothing() {
        assertEquals(answer.play(new Ball(0, 1)), BallStatus.NOTHING);
    }
}
