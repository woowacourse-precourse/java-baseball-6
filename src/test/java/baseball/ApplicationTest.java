package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

import baseball.domain.BaseballNumber;
import baseball.domain.BaseballScore;
import baseball.service.BaseballService;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

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
        BaseballService baseballService = new BaseballService();
        //when

        Throwable thrown = catchThrowable(() -> baseballService.initializeComputerNumber());
        //then
        assertThat(thrown).as("initializeComputerNumber_테스트").doesNotThrowAnyException();
    }

    @Test
    void 숫자의_개수가_3개이상_입력_예외() {

        //given
        String input = "1234";

        //when
        //then
        assertThatThrownBy(() -> new BaseballNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력의 길이는 3이어야합니다.");
    }

    @Test
    void 중복된_숫자가_들어왔을때_예외() {
        //given
        String input = "484";
        //when
        //then
        assertThatThrownBy(() -> new BaseballNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("모든 입력된 값은 달라야합니다.");
    }

    @Test
    void initializeUserNumber_유효성테스트() {
        //initializeUserNumber메서드의 주기능이되는 BaseballNumber의 생성자를 테스트
        //given
        String str1 = "123";
        String str2 = "456";
        String str3 = "789";
        //when
        final Throwable thrown1 = catchThrowable(() -> new BaseballNumber(str1));
        final Throwable thrown2 = catchThrowable(() -> new BaseballNumber(str2));
        final Throwable thrown3 = catchThrowable(() -> new BaseballNumber(str3));

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
        final Throwable thrown1 = catchThrowable(() -> new BaseballNumber(str1));
        final Throwable thrown2 = catchThrowable(() -> new BaseballNumber(str2));
        final Throwable thrown3 = catchThrowable(() -> new BaseballNumber(str3));

        //then
        assertThat(thrown1).as("initializeUserNumber_테스트").isInstanceOf(IllegalArgumentException.class);
        assertThat(thrown2).as("initializeUserNumber_테스트").isInstanceOf(IllegalArgumentException.class);
        assertThat(thrown3).as("initializeUserNumber_테스트").isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void compareNumber_테스트() {
        //given
        //3스트라이크
        BaseballNumber computer1 = new BaseballNumber("123");
        BaseballNumber user1 = new BaseballNumber("123");
        //3스트라이크
        BaseballNumber computer2 = new BaseballNumber("123");
        BaseballNumber user2 = new BaseballNumber("123");
        //2볼 1스트라이크
        BaseballNumber computer3 = new BaseballNumber("456");
        BaseballNumber user3 = new BaseballNumber("465");
        //2볼 1스트라이크
        BaseballNumber computer4 = new BaseballNumber("789");
        BaseballNumber user4 = new BaseballNumber("879");
        //when
        BaseballScore resultBaseballScore1 = BaseballNumber.compareNumber(computer1, user1);
        BaseballScore resultBaseballScore2 = BaseballNumber.compareNumber(computer2, user2);
        BaseballScore resultBaseballScore3 = BaseballNumber.compareNumber(computer3, user3);
        BaseballScore resultBaseballScore4 = BaseballNumber.compareNumber(computer4, user4);
        boolean result1 = BaseballScore.isBaseballScoreEqual(resultBaseballScore1, resultBaseballScore2);
        boolean result2 = BaseballScore.isBaseballScoreEqual(resultBaseballScore3, resultBaseballScore4);
        //then
        assertThat(result1).isEqualTo(true);
        assertThat(result2).isEqualTo(true);
    }

}
