package baseball.RestartCalculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import baseball.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class restartValidatorTests extends NsTest {

    @DisplayName("재시작 번호가 숫자가 아닐 때")
    @Test
    void validateRestartNotNumberInputTest() {
        assertRandomNumberInRangeTest(
                () -> {
                    // when
                    run("246", "135", "a", "597", "589", "2");
                    // then
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                // given
                1, 3, 5, 5, 8, 9
        );
    }

    @DisplayName("재시작 번호가 두자리일 때")
    @Test
    void validateRestartLongLengthInputTest() {
        assertRandomNumberInRangeTest(
                () -> {
                    // when
                    run("246", "135", "12", "597", "589", "2");
                    // then
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                // given
                1, 3, 5, 5, 8, 9
        );
    }

    @DisplayName("재시작 번호가 1,2가 아닌 숫자일 때")
    @Test
    void validateRestartNotAppropriateNumberInputTest() {
        assertRandomNumberInRangeTest(
                () -> {
                    // when
                    run("246", "135", "3", "597", "589", "2");
                    // then
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                // given
                1, 3, 5, 5, 8, 9
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
