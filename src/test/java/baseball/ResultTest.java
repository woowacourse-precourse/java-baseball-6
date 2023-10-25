package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.result.Result;
import baseball.result.Status;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultTest {
    @Test
    @DisplayName("3스트라이크일 경우 isWin이 true를 반환한다.")
    public void testIsWin() {
        // given
        Result result = new Result(new Status(0), new Status(3));

        // when
        boolean res = result.isWin();

        // then
        assertThat(res).isEqualTo(true);
    }

    @Test
    @DisplayName("3스트라이크가 아닐 경우 isWin이 false를 반환한다.")
    public void testIsNotWin() {
        // given
        Result result = new Result(new Status(3), new Status(0));

        // when
        boolean res = result.isWin();

        // then
        assertThat(res).isEqualTo(false);
    }
}
