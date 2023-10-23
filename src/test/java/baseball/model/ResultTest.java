package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultTest {

    @Test
    @DisplayName("볼과 스트라이크 결과를 저장한다.")
    public void 볼과_스트라이크_결과를_저장한다() {
        //given
        Result result = new Result();
        result.countUpBall();
        result.countUpStrike();

        //then
        assertThat(result.toString()).isEqualTo("1볼 1스트라이크");
    }

    @Test
    @DisplayName("볼 결과를 저장한다.")
    public void 볼_결과를_저장한다() {
        //given
        Result result = new Result();
        result.countUpBall();

        //then
        assertThat(result.toString()).isEqualTo("1볼");
    }

    @Test
    @DisplayName("스트라이크 결과를 저장한다.")
    public void 스트라이크_결과를_저장한다() {
        //given
        Result result = new Result();
        result.countUpStrike();

        //then
        assertThat(result.toString()).isEqualTo("1스트라이크");
    }

    @Test
    @DisplayName("낫싱 결과를 저장한다.")
    public void 낫싱_결과를_저장한다() {
        //given
        Result result = new Result();

        //then
        assertThat(result.toString()).isEqualTo("낫싱");
    }
}
