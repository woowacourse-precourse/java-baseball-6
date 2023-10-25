package baseball.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BaseballGameNumbersConvertorTest {

    @Test
    void 플레이어의_입력을_숫자_리스트로_변환할_수_있다() {
        String playerInput = "1234";
        List<Integer> baseballGameNumbers = BaseballGameNumbersConvertor.convertBaseballGameNumbers(
            playerInput, 4);

        assertThat(baseballGameNumbers).isEqualTo(List.of(1, 2, 3, 4));
    }

    @Test
    void 플레이어의_입력과_정답의_길이가_다른_경우_예외를_발생시킨다() {
        String playerInput = "1234";
        int answerSize = 10;

        assertThatThrownBy(
            () -> BaseballGameNumbersConvertor
                .convertBaseballGameNumbers(playerInput, answerSize))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"123f", "fail", "12 3"})
    void 플레이어의_입력에_숫자가_아닌_입력이_있는_경우_예외를_발생시킨다(String playerInput) {

        assertThatThrownBy(
            () -> BaseballGameNumbersConvertor
                .convertBaseballGameNumbers(playerInput, 4))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
