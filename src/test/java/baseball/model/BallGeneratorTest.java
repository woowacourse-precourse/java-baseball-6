package baseball.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BallGeneratorTest {
    BallGenerator ballGenerator;
    List<String> range;

    @BeforeEach
    void setUp() {
        ballGenerator = BallGenerator.getInstance();
        range = List.of("1", "2", "3", "4", "5", "6", "7", "8", "9");
    }

    @Test
    void 랜덤_공번호_생성() {
        assertTrue(range.contains(ballGenerator.createRandomBall()));
    }

    @Test
    void 컴퓨터_공번호_중복숫자_판별() {
        List<String> balls = ballGenerator.makeComputerBalls();
        assertThat(new HashSet<>(balls).size()).isEqualTo(balls.size());
    }

}