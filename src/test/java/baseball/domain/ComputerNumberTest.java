package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class ComputerNumberTest {

    @Test
    void 컴퓨터_랜덤_숫자_길이_확인() {
        List<Integer> computerNumber = new ComputerNumber().getComputerNumber();
        assertThat(computerNumber).hasSize(3);
    }

    @Test
    void 컴퓨터_랜덤_숫자_중복_확인() {
        int result = (int) new ComputerNumber().getComputerNumber().stream().distinct().count();
        assertThat(result).isEqualTo(3);
    }

    @Test
    void 컴퓨터_랜덤_숫자_범위_확인() {
        List<Integer> computerNumber = new ComputerNumber().getComputerNumber();
        assertThat(computerNumber.stream().allMatch(num -> 1 <= num && num <= 9)).isTrue();
    }
}
