package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Assertions;
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
        List<Integer> generatedNumber = ComputerNumberGenerator.generate();

        // Check if the size is 3
        assertThat(generatedNumber).hasSize(3);

        // Check if each digit is between 1 and 9
        for (int digit : generatedNumber) {
            assertThat(digit).isBetween(1, 9);
        }

        // Check if each digit is unique
        assertThat(generatedNumber).doesNotHaveDuplicates();
    }


    @Test
    void 야구게임_시작_출력() {
        assertSimpleTest(() -> {
            run();
            assertThat(output()).contains("숫자 야구 게임을 시작합니다.");
        });
    }

    @Test
    void 사용자_입력_테스트() {
        assertSimpleTest(() -> {
            run("123");
            assertThat(output()).contains("숫자를 입력하세요.");
        });
    }

    @Test
        // error handling for sizecheck
    void 사용자_숫자_입력_테스트() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            runException("1234");
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            runException("12");
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            runException("1");
        });
    }

    @Test
        // error handling for numbercheck
    void 사용자_숫자_입력_테스트2() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            runException("111");
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            runException("112");
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            runException("311");
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            runException("121");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
