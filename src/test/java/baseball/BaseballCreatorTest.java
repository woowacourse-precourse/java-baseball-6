package baseball;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class BaseballCreatorTest {
    BaseballCreator baseballCreator = new BaseballCreator(new FixedNumberGenerator());

    @Test
    @DisplayName("사용자 공을 생성")
    void createPlayerBallsTest() {
        // given: 사용자 공이 [1,4,3]
        List<Integer> playerBalls = baseballCreator.createPlayerBalls("143");
        // when
        List<Integer> want = List.of(1, 4, 3);
        // then
        assertThat(playerBalls).containsExactlyElementsOf(want);
    }

    @Test
    void createComputerBallsTest() {
        // given: 컴퓨터 공이 [1,2,3]
        List<Integer> computerBalls = baseballCreator.createComputerBalls();
        // when:
        List<Integer> want = List.of(7, 1, 3);
        // then
        assertThat(computerBalls).containsExactlyElementsOf(want);
    }

    static class FixedNumberGenerator implements NumberGenerator {
        private List<Integer> fixedNumbers = Lists.newArrayList(7, 1, 3);

        @Override
        public int generate() {
            return fixedNumbers.remove(0);
        }
    }
}
