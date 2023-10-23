package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Nested;

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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

@DisplayName("예외처리테스트")
class exceptionTest{
    @DisplayName("자연수가 아닌 숫자")
    @Test
    void 자연수_아닌_숫자() {
        String input = "김태현";
        assertThatThrownBy(() -> Application.isNotDigitNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("중복된 숫자 입력")
    @Test
    void 중복된_숫자_입력(){
        String input = "333";
        assertThatThrownBy(() -> Application.isSameNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Nested
    @DisplayName("1이나 2가 아닌 재시작 번호")
    @Test
    void 잘못된_재시작_번호(){
        int retryNum = 3;
        assertThatThrownBy(() -> Application.isCorrectRetryNumber(retryNum))
                .isInstanceOf(IllegalArgumentException.class);
    }

}




