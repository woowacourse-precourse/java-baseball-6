package baseballtest.App;

import baseball.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AppTest extends NsTest {
    @Test
    void 숫자생성_예외_테스트() {
        assertSimpleTest(() ->  // 숫자 아님
                assertThatThrownBy(() -> runException("ㄹㅈㄷ"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->  // 중복
                assertThatThrownBy(() -> runException("222"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->  // 문자 길이 3 아님
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 재시작종료_선택_예외_테스트() {
        assertRandomNumberInRangeTest(() ->{    // 1과 2 아님
                assertThatThrownBy(() -> runException("135","ㅔ"))
                        .isInstanceOf(IllegalArgumentException.class);
        },1,3,5
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
