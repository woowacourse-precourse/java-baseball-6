package baseball.view;

import baseball.common.exception.input.InputException;
import baseball.dto.request.RestartAnswerRequest;
import baseball.dto.request.UserNumberRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InputViewTest {
    private static ByteArrayInputStream inputStream;

    @Test
    @DisplayName("숫자 입력받기")
    public void 숫자_입력() throws Exception {

        // given
        setReadLine("123");

        // when
        UserNumberRequest expect = new UserNumberRequest("123");
        UserNumberRequest actual = InputView.requestUserNumber();

        // then
        assertThat(actual).usingRecursiveComparison().isEqualTo(expect);
    }

    @Test
    @DisplayName("숫자 입력에서 공백을 입력시 예외가 발생한다.")
    public void 숫자_공백_입력() throws Exception {

        // given
        setReadLine(" ");

        // when

        // then
        assertThrows(InputException.class, InputView::requestUserNumber);
    }

    @Test
    @DisplayName("재시작 여부 입력받기")
    public void 재시작_여부_입력() throws Exception {

        // given
        setReadLine("1");

        // when
        RestartAnswerRequest expect = new RestartAnswerRequest("1");
        RestartAnswerRequest actual = InputView.requestContinueAnswer();

        // then
        assertThat(actual).usingRecursiveComparison().isEqualTo(expect);
    }

    @Test
    @DisplayName("재시작 여부에서 잘못된 값 입력 시 예외가 발생한다")
    public void 재시작_여부_잘못_입력() throws Exception {

        // given
        setReadLine(" ");

        // when

        // then
        assertThrows(InputException.class, () -> {
            InputView.requestContinueAnswer();
        });
    }

    public void setReadLine(String readLine) {
        inputStream = new ByteArrayInputStream(readLine.getBytes());
        System.setIn(inputStream);
    }
}