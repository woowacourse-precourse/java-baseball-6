package baseball;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.domain.Validator;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ValidatorTest {
    private Validator validator = new Validator();

    @Test
    void 숫자가_아닌_값_입력() {
        List<String> userBalls = List.of("1e3".split(""));
        assertThatThrownBy(() -> validator.validateNumber(userBalls))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    void 숫자의_길이가_3이_아니면_예외() {
        List<String> userBalls = List.of("1234".split(""));

        assertThatThrownBy(() -> validator.validateBallLength(userBalls))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    void 숫자의_길이가_3이_아니면_예외2() {
        List<String> userBalls = List.of("1");

        assertThatThrownBy(() -> validator.validateBallLength(userBalls))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    void 숫자의_범위는_1부터_9() {
        List<String> userBalls = List.of("102".split(""));

        assertThatThrownBy(() -> validator.validateNumberRange(userBalls))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    void 중복된_숫자() {
        List<String> userBalls = List.of("112".split(""));

        assertThatThrownBy(() -> validator.validateDuplicate(userBalls))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    void 모든_검증() {
        List<String> cases = List.of("1234", "1e3", "112", "102");
        for (int i = 0; i < cases.size(); i++) {
            List<String> userBalls = List.of(cases.get(i).split(""));
            assertThatThrownBy(() -> validator.validateStandard(userBalls)).isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    void 검증_통과() {
        assertThatCode(() -> validator.validateStandard(List.of("123".split("")))).doesNotThrowAnyException();
    }

    @Test
    void 게임_종료_후_예외() {
        assertThatThrownBy(() -> validator.validateEndOrRestart("3")).isInstanceOf(IllegalArgumentException.class);
    }

}
