package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
    @Test
    void initializeComputerNumber_유효성테스트() {
        //given
        //when
        final Throwable thrown = catchThrowable(()->BaseballNumber.initializeComputerNumber());
        //then
        assertThat(thrown).as("initializeComputerNumber_테스트").doesNotThrowAnyException();
    }
    @Test
    void 숫자의_개수가_3개이상_입력_예외() {
        //given
        List<Integer> testList = new ArrayList(Arrays.asList(1, 2, 3, 4));
        //when
        //then
        assertThatThrownBy(() -> new BaseballNumber(testList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("게임을 진행할 수는 항상 3개여야 합니다.");
    }
    @Test
    void 중복된_숫자가_들어왔을때_예외() {
        //given
        List<Integer> testList = new ArrayList(Arrays.asList(2, 2, 3));
        //when
        //then
        assertThatThrownBy(() -> new BaseballNumber(testList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("서로 같은 숫자들은 입력될 수 없습니다.");
    }

}
