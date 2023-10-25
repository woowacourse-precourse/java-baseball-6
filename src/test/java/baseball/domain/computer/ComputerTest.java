package baseball.domain.computer;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.baseballnumber.BaseballNumbers;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("[ComputerTest]")
class ComputerTest {

    @Test
    @DisplayName("임의의 세 숫자를 가진 BaseballNumbers로 Computer를 생성할 수 있다.")
    void constructedByRandomValueBaseballNumbers() {
        // given
        List<Integer> randomIntegers = Arrays.asList(3, 6, 5);
        BaseballNumbers baseballNumbers = new BaseballNumbers(randomIntegers);

        // when
        Computer computer = new Computer(baseballNumbers);

        // then
        assertThat(computer.numbers()).isEqualTo(baseballNumbers);
    }
}