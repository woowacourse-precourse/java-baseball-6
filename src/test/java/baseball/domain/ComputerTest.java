package baseball.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComputerTest {
    private Computer computer;

    @BeforeEach
    void init() {
        computer = new Computer();
    }

    @Test
    @DisplayName("랜덤의 숫자 3개 생성 테스트")
    void generateThreeRandomNumbers() {
        Assertions.assertThat(computer.getRandomNumber().size()).isEqualTo(3);
    }
}