package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.utils.RandomUtil;

class ApplicationTest extends NsTest {
    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 난수_생성후_개수_테스트() {
        RandomUtil randomUtil = new RandomUtil();
        assertThat(randomUtil.createRandomList().size()).isEqualTo(3);
    }

    @Test
    void 난수_생성후_범위_테스트() {
        RandomUtil randomUtil = new RandomUtil();
        randomUtil.createRandomList().forEach(number ->
                assertThat(number).isBetween(1, 9)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
