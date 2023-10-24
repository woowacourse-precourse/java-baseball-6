package baseball.util;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class RandomNumberGeneratorTest {

    @Test
    void 컴퓨터가_랜덤으로_숫자_생성하기() {
        final List<Integer> expected = List.of(1, 2, 3);
        assertRandomNumberInRangeTest(
                () -> {
                    final List<Integer> actual = RandomNumberGenerator.generate();
                    assertThat(actual).isEqualTo(expected);
                },
                1, 2, 3
        );
    }
}
