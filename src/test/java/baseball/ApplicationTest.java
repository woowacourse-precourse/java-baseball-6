package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

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
}
