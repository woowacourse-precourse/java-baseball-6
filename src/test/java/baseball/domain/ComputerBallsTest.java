package baseball.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ComputerBallsTest {
    private ComputerBalls computer;

    @BeforeEach
    void setUp() {
        computer = new ComputerBalls();
    }

    @Test
    void 컴퓨터가_볼을_세개_가짐() {
        computer.setRandomBalls();
        assertThat(computer.balls.size()).isEqualTo(3);
    }
}