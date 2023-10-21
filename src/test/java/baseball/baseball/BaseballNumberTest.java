package baseball.baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class BaseballNumberTest {

    private BaseballNumber answer;

    @BeforeEach
    public void init() {
        answer = new BaseballNumber(List.of(1, 2, 3));
    }

    @Test
    public void 볼_갯수를_계산할_수_있다() throws Exception {
        // given
        BaseballNumber baseballNumber = new BaseballNumber(List.of(3, 1, 2));

        // when
        int numBall = answer.countBall(baseballNumber);

        //then
        assertThat(numBall).isEqualTo(3);
    }

    @Test
    public void 스트라이크_갯수를_계산할_수_있다() throws Exception {
        // given
        BaseballNumber baseballNumber = new BaseballNumber(List.of(1, 2, 5));

        // when
        int numStrike = answer.countStrike(baseballNumber);

        //then
        assertThat(numStrike).isEqualTo(2);
    }

}