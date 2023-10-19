package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ComputerTest {

    @Test
    @DisplayName("컴퓨터 객체 생성 시 숫자 값이 무작위로 중복 없이 잘 할당되는지 확인")
    void GenerateRandomNumbers() {
        Computer computer = new Computer();
        for (int i = 0; i < 100000; i++) {
            List<Baseball> baseballs = computer.generateBaseball();
            assertThat(baseballs.stream().distinct().count()).isEqualTo(3);
        }
    }

}