package baseball.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

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

}