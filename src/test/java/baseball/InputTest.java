package baseball;

import baseball.model.ComputerRandomNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class InputTest {
    @Test
    @DisplayName("컴퓨터 랜덤 숫자 생성 테스트")
    void 컴퓨터_랜덤_숫자_생성(){
        ComputerRandomNumbers computerRandomNumbers = new ComputerRandomNumbers();
        List<Integer> test = computerRandomNumbers.generate();

        assertThat(test.size()).isEqualTo(3);
    }
}
