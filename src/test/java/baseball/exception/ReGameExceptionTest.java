package baseball.exception;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ReGameExceptionTest {
    private final ReGameException exception = new ReGameException();

    @Test
    void 게임_재시작_미입력(){
        String request = "";

        assertThatThrownBy(() ->
                exception.validation(request)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() ->
                exception.validation(request)).hasMessage("숫자 하나만 입력해주세요.");
    }

    @Test
    void 게임_재시작_2글자_이상_입력(){
        String request = "352";

        assertThatThrownBy(() ->
                exception.validation(request)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() ->
                exception.validation(request)).hasMessage("숫자 하나만 입력해주세요.");
    }

    @Test
    void 게임_재시작_미지정_숫자_입력(){
        String request = "8";

        assertThatThrownBy(() ->
                exception.validation(request)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() ->
                exception.validation(request)).hasMessage("숫자 1 또는 2를 입력해주세요.");
    }

    @Test
    void 게임_재시작_미지정_글자_입력(){
        String request = "ㄱ";

        assertThatThrownBy(() ->
                exception.validation(request)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() ->
                exception.validation(request)).hasMessage("숫자 1 또는 2를 입력해주세요.");
    }
}