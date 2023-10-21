package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.logic.InputValidator;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class InputValidatorTest {

    private final InputValidator validator = new InputValidator();

    @Test
    void 사용자_입력_통합_검증() {
        // given
        String input = "369";

        // when
        List<Integer> userInput = validator.validateInput(input);

        // then
        assertThat(userInput.size()).isEqualTo(3);
        assertThat(userInput.getClass().getSimpleName()).isEqualTo("ArrayList");
        assertThat(userInput).contains(3, 6, 9);
    }

    @Test
    void 숫자_길이_예외_발생() {
        // given
        String input = "3478";

        // when, then
        assertThatThrownBy(() -> validator.validateLength(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력한 숫자의 길이를 확인하세요.");
    }

    @Test
    void 사용자_입력_리스트_변환() {
        // given
        String input = "234";

        // when
        List<Integer> userInput = validator.convertStrToList(input);

        // then
        assertThat(userInput.size()).isEqualTo(3);
        assertThat(userInput.getClass().getSimpleName()).isEqualTo("ArrayList");
    }

    @Test
    void 사용자_입력_범위_검증() {
        // given
        List<Integer> correctInput = new ArrayList<>();
        List<Integer> errorInput = new ArrayList<>();

        // when
        correctInput.add(1);
        correctInput.add(7);
        correctInput.add(6);
        errorInput.add(0);
        errorInput.add(1);
        errorInput.add(3);

        // then
        assertThatNoException().isThrownBy(() ->
                validator.validateRange(correctInput));

        assertThatThrownBy(() ->
                validator.validateRange(errorInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력 값의 범위(1~9)를 확인하세요.");
    }

    @Test
    void 사용자_입력_중복_검증() {
        // given
        List<Integer> correctInput = new ArrayList<>();
        List<Integer> errorInput = new ArrayList<>();

        // when
        correctInput.add(1);
        correctInput.add(7);
        correctInput.add(6);
        errorInput.add(2);
        errorInput.add(3);
        errorInput.add(3);

        // then
        assertThatNoException().isThrownBy(() ->
                validator.validateDuplicate(correctInput));

        assertThatThrownBy(() ->
                validator.validateDuplicate(errorInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 숫자가 존재합니다.");
    }

    @Test
    void 사용자_입력_명령어_검증() {
        // given
        String correctInput = "1";
        String wrongInput = "3";

        // when, then
        assertThatNoException().isThrownBy(() ->
                validator.validateCommand(correctInput));

        assertThatThrownBy(() ->
                validator.validateCommand(wrongInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("명령어를 확인하세요. 1 (재시작), 2 (종료)");
    }
}
