package utils;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("상대방 수 생성 테스트")
class RandomUtilTest extends NsTest {
    @Test
    @DisplayName("정상 작동")
    void success() {
        List<Integer> answer = List.of(1, 2, 3);
        assertRandomNumberInRangeTest(
                () -> {
                    run("");
                    assertThat(output()).isEqualTo(answer.toString());
                },
                1, 2, 3
        );
    }

    @Override
    protected void runMain() {
        System.out.println(RandomUtil.generateBaseballNumber());
    }
}