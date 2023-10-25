package utils;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import constant.TestConstant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("상대방 수 생성 테스트")
class RandomUtilTest extends NsTest {
    @Test
    @DisplayName("정상 작동")
    void success() {
        assertRandomNumberInRangeTest(
                () -> {
                    run(TestConstant.EMPTY_TEST);
                    assertThat(output()).isEqualTo(TestConstant.FIRST_ANSWER_SPLIT.toString());
                },
                TestConstant.FIRST_ANSWER_FIRST_ELEM, TestConstant.FIRST_ANSWER_OTHER_ELEM
        );
    }

    @Override
    protected void runMain() {
        System.out.println(RandomUtil.generateBaseballNumber());
    }
}