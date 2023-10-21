package baseball.exception;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BallExceptionTest {
    private final BallException exception = new BallException();

    @Test
    void 숫자_0_입력시_예외_발생(){
        String number = "025";
        assertThatThrownBy(() ->
                exception.validation(number))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() ->
                exception.validation(number))
                .hasMessage("1~9까지의 숫자를 입력해주세요.");
    }

    @Test
    void 글자_입력시_예외_발생(){
        String number = "가나다";
        assertThatThrownBy(() ->
                exception.validation(number))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() ->
                exception.validation(number))
                .hasMessage("1~9까지의 숫자를 입력해주세요.");
    }

    @Test
    void 숫자_2개_이하일시_예외_발생(){
        String number = "15";
        assertThatThrownBy(() ->
                exception.validation(number))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() ->
                exception.validation(number))
                .hasMessage("숫자는 3개만 입력해주세요.");
    }

    @Test
    void 숫자_4개_이상일시_예외_발생(){
        String number = "1598";
        assertThatThrownBy(() ->
                exception.validation(number))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() ->
                exception.validation(number))
                .hasMessage("숫자는 3개만 입력해주세요.");
    }

    @Test
    void 숫자_중복일시_예외_발생(){
        String number = "155";
        assertThatThrownBy(() ->
                exception.validation(number))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() ->
                exception.validation(number))
                .hasMessage("숫자는 중복없이 입력해주세요.");
    }
}