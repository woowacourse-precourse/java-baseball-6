package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    Compare compare;

    @BeforeEach
    void Init(){
        compare = new Compare();
    }

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
    @DisplayName("3볼 테스트")
    void check_ball(){
        assertThat("3볼").isEqualTo(compare.Classification(Arrays.asList(3,1,2), Arrays.asList(1,2,3)));
    }

    @Test
    @DisplayName("3스트라이크 테스트")
    void check_strike(){
        assertThat("3스트라이크").isEqualTo(compare.Classification(Arrays.asList(1,2,3), Arrays.asList(1,2,3)));
    }

    @Test
    @DisplayName("낫싱 테스트")
    void check_nothing(){
        assertThat("낫싱").isEqualTo(compare.Classification(Arrays.asList(1,2,3), Arrays.asList(4,5,6)));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}