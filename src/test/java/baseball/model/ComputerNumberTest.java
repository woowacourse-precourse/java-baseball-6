package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComputerNumberTest {
    @Test
    @DisplayName("컴퓨터 생성한 랜덤 번호가 실제로 중복 자리수가 없는지 검증한다.")
    public void 컴퓨터_생성자_테스트() throws Exception {
        // given
        ComputerNumber computer = new ComputerNumber();

        // when
        List<Integer> computerNum = computer.getComputerNumber();

        // then
        assertThat(computerNum.get(0)).isNotEqualTo(computerNum.get(1));
        assertThat(computerNum.get(1)).isNotEqualTo(computerNum.get(2));
        assertThat(computerNum.get(2)).isNotEqualTo(computerNum.get(0));
    }

}
