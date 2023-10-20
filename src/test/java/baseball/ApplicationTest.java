package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    void 컴퓨터_숫자_생성_테스트() {
        String generatedNumber = ComputerNumberGenerator.generate();

        // Check if the size is 3
        assertThat(generatedNumber).hasSize(3);

        // Check if each digit is between 1 and 9
        for (char digitChar : generatedNumber.toCharArray()) {
            int digit = Character.getNumericValue(digitChar);
            assertThat(digit).isBetween(1, 9);
        }

        // Check if each digit is unique
        assertThat(generatedNumber.chars().distinct().count()).isEqualTo(3);
    }


    @Test
    void 야구게임_시작_출력() {
        assertSimpleTest(() -> {
            run();
            assertThat(output()).contains("숫자 야구 게임을 시작합니다.");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
