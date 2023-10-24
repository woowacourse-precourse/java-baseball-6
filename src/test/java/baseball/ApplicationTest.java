package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
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

    @Test
    @DisplayName("임의의 숫자 3개를 생성한다")
    void 임의의_숫자_3개를_생성한다() {

        // Given
        List<Integer> randomNumbers = RandomNumberGenerator.createNumbers();

        // When & Then
        assertThat(randomNumbers).hasSize(3);
    }

    @Test
    @DisplayName("사용자가 입력한 숫자가 3자리가 아니면 예외를 반환한다")
    void 사용자가_입력한_숫자가_3자리인지_체크한다() {

        // Given
        String testNumber = "1234";

        // When & Then
        Assertions.assertThatThrownBy(() -> UserNumberValidator.validateThreeDigitNumber(testNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("세자리 숫자가 아닙니다");
    }

    @Test
    @DisplayName("사용자가 입력한 숫자의 각 자리가 중복된다면 예외를 반환한다")
    void 사용자가_입력한_숫자가_중복되는지_체크한다() {

        // Given
        String testNumber = "112";

        // When & Then
        Assertions.assertThatThrownBy(() -> UserNumberValidator.validateDuplicatedNumber(testNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 숫자를 입력했습니다");
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
