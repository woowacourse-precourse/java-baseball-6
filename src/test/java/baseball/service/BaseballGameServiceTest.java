package baseball.service;

import baseball.domain.BallCount;
import baseball.domain.Computer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballGameServiceTest {

    private BaseballGameService baseballGameService = new BaseballGameServiceImpl();

    @DisplayName("임의의 세 자리 computer number를 생성할 수 있다.")
    @Test
    void setComputerNumbers() {
        // given, when
        Computer computer = baseballGameService.setComputerNumbers();

        // then
        assertThat(computer.getComputerNumbers()).hasSize(3);
    }

    @DisplayName("서로 중복되지 않는 임의의 세 자리 computer number를 생성할 수 있다.")
    @Test
    void setComputerNumbersWithoutDuplicate() {
        // given, when
        Computer computer = baseballGameService.setComputerNumbers();

        // then
        assertThat(computer.getComputerNumbers().get(0)).isNotEqualTo(computer.getComputerNumbers().get(1));
        assertThat(computer.getComputerNumbers().get(1)).isNotEqualTo(computer.getComputerNumbers().get(2));
        assertThat(computer.getComputerNumbers().get(2)).isNotEqualTo(computer.getComputerNumbers().get(0));
    }

    @DisplayName("임의의 세 자리 숫자를 입력하면 볼과 스트라이크에 대한 결과를 반환한다.")
    @ParameterizedTest
    @CsvSource({"135", "329", "273", "421"})
    void playGame(String inputNumbers) {
        // given
        Computer computer = new Computer(List.of(1, 2, 3));

        // when
        BallCount ballCount = baseballGameService.playGame(computer, inputNumbers);

        // then
        assertThat(ballCount.getStrike()).isEqualTo(1);
        assertThat(ballCount.getBall()).isEqualTo(1);
    }

}