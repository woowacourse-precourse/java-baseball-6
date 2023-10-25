package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.Computer;
import baseball.domain.Round;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class BaseballTest {

    @Test
    void 랜덤_숫자_출력() {
        Computer rn = new Computer();
        assertThat(rn.make().size()).isEqualTo(3);
    }

    @Test
    void 세자리_숫자_간_비교결과_출력() {
        Round round = new Round();
        List<Integer> num1 = Arrays.asList(1, 2, 3);
        List<Integer> num2 = Arrays.asList(1, 4, 2);
        round.compare(num1, num2);

        assertThat(round.getResult()).isEqualTo("1볼 1스트라이크");
    }

}
