package baseball;

import baseball.util.CompareNumber;
import baseball.util.RandomNumberGenerator;
import baseball.validation.InputValidation;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
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
    void 생성된_무작위_숫자가_3자리인지_테스트() {
        List<Integer> numbers = RandomNumberGenerator.generate();
        assertThat(numbers.size()).isEqualTo(3);
    }

    @Test
    void 생성된_무작위_숫자가_중복이_없는지_테스트() {
        for (int i = 0; i < 100; i++) {
            List<Integer> numbers = RandomNumberGenerator.generate();
            assertThat(numbers).doesNotHaveDuplicates();
        }
    }

    @Test
    void 입력된_값이_3자리가_맞는지_테스트() {
        assertThatThrownBy(() -> InputValidation.Number("12"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> InputValidation.Number("1234"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력된_값이_숫자인지_테스트() {
        assertThatThrownBy(() -> InputValidation.Number("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 스트라이크_개수_판별_테스트() {
        assertThat(CompareNumber.CountStrike(List.of(1, 2, 3), List.of(1, 2, 3))).isEqualTo(3);
        assertThat(CompareNumber.CountStrike(List.of(1, 2, 3), List.of(1, 2, 4))).isEqualTo(2);
        assertThat(CompareNumber.CountStrike(List.of(1, 2, 3), List.of(1, 4, 5))).isEqualTo(1);
        assertThat(CompareNumber.CountStrike(List.of(1, 2, 3), List.of(4, 5, 6))).isEqualTo(0);
    }

    @Test
    void 볼_개수_판별_테스트() {
        assertThat(CompareNumber.CountBall(List.of(1, 2, 3), List.of(1, 2, 3))).isEqualTo(0);
        assertThat(CompareNumber.CountBall(List.of(1, 2, 3), List.of(4, 5, 6))).isEqualTo(0);
        assertThat(CompareNumber.CountBall(List.of(1, 2, 3), List.of(1, 3, 4))).isEqualTo(1);
        assertThat(CompareNumber.CountBall(List.of(1, 2, 3), List.of(3, 2, 5))).isEqualTo(1);
        assertThat(CompareNumber.CountBall(List.of(1, 2, 3), List.of(5, 3, 4))).isEqualTo(1);
        assertThat(CompareNumber.CountBall(List.of(1, 2, 3), List.of(2, 1, 4))).isEqualTo(2);
        assertThat(CompareNumber.CountBall(List.of(1, 2, 3), List.of(1, 3, 2))).isEqualTo(2);
        assertThat(CompareNumber.CountBall(List.of(1, 2, 3), List.of(3, 1, 2))).isEqualTo(3);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
