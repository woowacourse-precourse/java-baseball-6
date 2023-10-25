package baseball.controller;

import baseball.model.Ball;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RandomGeneratorTests {

    private RandomGenerator randomGenerator;
    RandomGeneratorTests() {
        randomGenerator = new RandomGenerator();
    }

    @Test()
    @DisplayName("볼 생성 테스트")
    void check_balls(){
        List<Ball> computer = randomGenerator.getComputer();
        assertThat(computer.size()).isEqualTo(3);
    }
}