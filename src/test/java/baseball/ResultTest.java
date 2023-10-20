package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResultTest {

    @Test
    public void nothing() throws Exception{
        //given
        Result result = new Result();

        //when

        //then
        Assertions.assertThat(result.toString())
                .isEqualTo("낫싱");
    }

    @Test
    public void strike1() throws Exception{
        //given
        Result result = new Result(1, 0);

        //when

        //then
        Assertions.assertThat(result.toString())
                .isEqualTo("1스트라이크");
    }

    @Test
    public void ball1() throws Exception{
        //given
        Result result = new Result(0, 1);

        //when

        //then
        Assertions.assertThat(result.toString())
                .isEqualTo("1볼");
    }

    @Test
    public void ball1_strike1() throws Exception{
        //given
        Result result = new Result(1, 1);

        //when

        //then
        Assertions.assertThat(result.toString())
                .isEqualTo("1볼 1스트라이크");
    }
}