package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BaseballGameNumbersTest {

    @Test
    void 랜덤_숫자_답안지를_가진_Grader를_만들_수_있다() {
        BaseballGameNumbers baseballGameNumbers = new BaseballGameNumbers();

        assertThat(baseballGameNumbers.getRandomNumbersGrader())
            .isInstanceOf(Grader.class);
    }

    @Test
    void BaseballGameNumbers를_통해_플레이어_입력이_게임_규칙에_맞는지_확인할_수_있다() {
        BaseballGameNumbers baseballGameNumbers = new BaseballGameNumbers();

        List<Integer> wrongSizeList = List.of(1, 2, 3, 4);
        List<Integer> wrongNumberList = List.of(-1, 10, 11);

        Assertions.assertAll(
            () -> assertThatThrownBy(
                () -> baseballGameNumbers.validatePlayerNumbers(wrongSizeList))
                .isInstanceOf(IllegalArgumentException.class),

            () -> assertThatThrownBy(
                () -> baseballGameNumbers.validatePlayerNumbers(wrongNumberList))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }
}
