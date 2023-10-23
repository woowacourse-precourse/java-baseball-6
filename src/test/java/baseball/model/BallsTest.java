package baseball.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

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
}
