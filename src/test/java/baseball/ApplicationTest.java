package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

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

    private List<Integer> computerNumbers;

    @BeforeEach
    void setup() {
        computerNumbers = Arrays.asList(1, 2, 3);
    }

    @Test
    @DisplayName("컴퓨터의 랜덤 숫자 생성 테스트")
    void generateUniqueRandomNumbers_test() {
        // when
        List<Integer> numbers = Application.generateUniqueRandomNumbers();

        // then
        assertThat(numbers).hasSize(3);
        assertThat(numbers.get(0)).isNotEqualTo(numbers.get(1));
        assertThat(numbers.get(0)).isNotEqualTo(numbers.get(2));
        assertThat(numbers.get(1)).isNotEqualTo(numbers.get(2));

        numbers.forEach(number -> {
            assertThat(number).isGreaterThanOrEqualTo(1);
            assertThat(number).isLessThanOrEqualTo(9);
        });
    }

    @Test
    @DisplayName("사용자 숫자 유효성 검사")
    void validateInput_test(){
        // when
        String input1 = "1234";
        String input2 = "122";
        String input3 = "12c";
        String input4 = "012";

        assertThatThrownBy(() -> Application.validateInput(input1))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> Application.validateInput(input2))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> Application.validateInput(input3))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> Application.validateInput(input4))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("게임 결과 비교 테스트")
    void evaluateAndDisplayGameResult_test() {
        // given
        List<Integer> userNumbers1 = Arrays.asList(1, 4, 3);
        // when
        boolean result1 = Application.evaluateAndDisplayGameResult(computerNumbers, userNumbers1);
        // then
        assertThat(result1).isFalse();

        // given
        List<Integer> userNumbers2 = Arrays.asList(1, 2, 3);
        // when
        boolean result2 = Application.evaluateAndDisplayGameResult(computerNumbers, userNumbers2);
        // then
        assertThat(result2).isTrue();
    }
}
