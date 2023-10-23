package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ResultTest {

    @Test
    void checkResult_메서드는_게임결과를_최신화한다(){
        List<Integer> userNumbers = List.of(1,2,3);
        List<Integer> computerNumbers = List.of(3,2,1);
        Result result = new Result();
        result.checkResult(userNumbers, computerNumbers);

        Assertions.assertThat(result.getBall()).isEqualTo(2);
        Assertions.assertThat(result.getStrike()).isEqualTo(1);
    }
}
