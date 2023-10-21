package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ComputerNumTest {
    @DisplayName("컴퓨터 3자리 수 생성 테스트")
    @Test
    public void genComputerNumTest() {
        // given
        ComputerNum computerNum = new ComputerNum();

        // when
        List<String> computerNumList = computerNum.genComputerNum();

        // then
        System.out.println(computerNumList);
        assertThat(computerNumList.size()).isEqualTo(3);
    }
}

