package baseball;

import baseball.domain.CreateNum;
import baseball.domain.RetryNum;
import baseball.domain.UserNum;
import baseball.service.BallStrikeCount;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
    void 생성된_숫자_길이_테스트() {
        CreateNum createNum = new CreateNum();
        createNum.setInitialReturnNum();
        assertThat(createNum.getCreateNum().length()).isEqualTo(3);
    }

    @Test
    void 입력한_숫자_길이_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> UserNum.isStrLenCorrect("12"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자_이외_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> UserNum.isDigitUserNum("a23"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 중복값_입력_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> UserNum.isDuplicateCheck("222"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 재시작_값_제외_입력_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> RetryNum.retryNumCheck("a"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 볼_스트라이크_카운트_테스트() {
        String createNum1 = "123";
        String userNum1 = "325";
        BallStrikeCount ballStrikeCount1 = new BallStrikeCount();
        int[] countResult1 = ballStrikeCount1.compareResult(createNum1, userNum1);
        assertThat(countResult1[0]).isEqualTo(1);
        assertThat(countResult1[1]).isEqualTo(1);
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
