package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("컴퓨터 도메인 테스트")
class ComputerTest {

    // 서로 다른 수만 존재하는지 어떻게 테스트할 수 있을까..?
    @DisplayName("컴퓨터는 서로 다른 임의의 수 3개를 선택한다.")
    @Test
    void generateComputerNumbers() {
        // given
        Computer computer = new Computer();

        // when
        computer.generateNumbers();

        // then
        assertThat(computer).extracting("numbers")
                .extracting("numbers").asList()
                .hasSize(3);
    }
}