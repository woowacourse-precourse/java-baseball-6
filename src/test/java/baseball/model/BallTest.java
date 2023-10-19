package baseball.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallTest {

    private Ball com;

    @BeforeEach
    void setup() {
        com = new Ball(0, 5);
    }

    @Test
    void strike() {
        assertThat(com.play(new Ball(0, 5))).isEqualTo(BallStatus.STRIKE);
    }
}
