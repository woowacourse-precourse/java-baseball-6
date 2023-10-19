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

    @Test
    void initializeUserNumber_유효성테스트() {
        //given
        String str1 = "123";
        String str2 = "456";
        String str3 = "789";
        //when
        final Throwable thrown1 = catchThrowable(()->BaseballNumber.initializeUserNumberForTest(str1));
        final Throwable thrown2 = catchThrowable(()->BaseballNumber.initializeUserNumberForTest(str2));
        final Throwable thrown3 = catchThrowable(()->BaseballNumber.initializeUserNumberForTest(str3));

        //then
        assertThat(thrown1).as("initializeUserNumber_테스트").doesNotThrowAnyException();
        assertThat(thrown2).as("initializeUserNumber_테스트").doesNotThrowAnyException();
        assertThat(thrown3).as("initializeUserNumber_테스트").doesNotThrowAnyException();
    }

    @Test
    void 사용자_입력이_숫자가_아닐때() {
        //given
        String str1 = "asdf";
        String str2 = "qwer";
        String str3 = "zxcv";
        //when
        final Throwable thrown1 = catchThrowable(()->BaseballNumber.initializeUserNumberForTest(str1));
        final Throwable thrown2 = catchThrowable(()->BaseballNumber.initializeUserNumberForTest(str2));
        final Throwable thrown3 = catchThrowable(()->BaseballNumber.initializeUserNumberForTest(str3));

        //then
        assertThat(thrown1).as("initializeUserNumber_테스트").isInstanceOf(IllegalArgumentException.class);
        assertThat(thrown2).as("initializeUserNumber_테스트").isInstanceOf(IllegalArgumentException.class);
        assertThat(thrown3).as("initializeUserNumber_테스트").isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void compareNumber_테스트() {
        //given
        //3스트라이크
        BaseballNumber computer1 = new BaseballNumber(new ArrayList(Arrays.asList(1, 2, 3)));
        BaseballNumber user1 = new BaseballNumber(new ArrayList(Arrays.asList(1, 2, 3)));
        //3스트라이크
        BaseballNumber computer2 = new BaseballNumber(new ArrayList(Arrays.asList(4, 5, 6)));
        BaseballNumber user2 = new BaseballNumber(new ArrayList(Arrays.asList(4, 5, 6)));
        //2볼 1스트라이크
        BaseballNumber computer3 = new BaseballNumber(new ArrayList(Arrays.asList(4, 5, 6)));
        BaseballNumber user3 = new BaseballNumber(new ArrayList(Arrays.asList(4, 6, 5)));
        //2볼 1스트라이크
        BaseballNumber computer4 = new BaseballNumber(new ArrayList(Arrays.asList(7, 8, 9)));
        BaseballNumber user4 = new BaseballNumber(new ArrayList(Arrays.asList(8, 7, 9)));
        //when
        BaseballScore resultBaseballScore1 = computer1.compareNumber(user1);
        BaseballScore resultBaseballScore2 = computer2.compareNumber(user2);
        BaseballScore resultBaseballScore3 = computer3.compareNumber(user3);
        BaseballScore resultBaseballScore4 = computer4.compareNumber(user4);
        boolean result1 = BaseballScore.isBaseballScoreEqual(resultBaseballScore1, resultBaseballScore2);
        boolean result2 = BaseballScore.isBaseballScoreEqual(resultBaseballScore3, resultBaseballScore4);
        //then
        assertThat(result1).isEqualTo(true);
        assertThat(result2).isEqualTo(true);
    }

}
