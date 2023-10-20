package baseball.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidationTest {

    @Test
    public void 중복된_숫자_입력시_예외_발생() {
        assertThatThrownBy(() -> Validation.validateSameNumber("144"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 입력한_문자열에_문자가_포함되어_있으면_예외_발생() {
        assertThatThrownBy(() -> Validation.validateThatInputIsNumeric("14j"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 입력한_숫자_개수가_3개가_넘으면_예외_발생() {
        assertThatThrownBy(() -> Validation.validateNumberOfNumbers("1234"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 입력한_숫자_개수가_3개보다_적으면_예외_발생() {
        assertThatThrownBy(() -> Validation.validateNumberOfNumbers("34"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 재시작_또는_종료_숫자를_잘못_입력하면_예외_발생() {
        assertThatThrownBy(() -> Validation.validateRestartOrEnd("3"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}