package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ResultTest {
    @Test
    public void 맞는_숫자_없는_경우() throws Exception {
        //given
        Result result = new Result();
        //when
        //then
        Assertions.assertThat(result.toString())
                .isEqualTo("낫싱");
    }

    @Test
    public void 스트라이크_1_볼_1_경우() throws Exception {
        //given
        Result result = new Result();
        //when
        result.addStrike();
        result.addBall();
        //then
        Assertions.assertThat(result.toString())
                .isEqualTo("1볼 1스트라이크");
    }


}
