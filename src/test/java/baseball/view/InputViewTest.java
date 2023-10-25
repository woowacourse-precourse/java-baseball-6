package baseball.view;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.exception.ErrorMessage;
import baseball.model.FinishInput;
import baseball.model.Number;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InputViewTest {

    private InputView inputView;


    @BeforeEach
    void setUp() {
        inputView = new InputView();
    }


    @Test
    void 유효한_입력_일때_Number_객체를_반환() {
        // given
        String input = "123\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // when
        Number result = inputView.readNumberInput();

        // then
        assertThat(result).usingRecursiveComparison().isEqualTo(new Number(123));
    }

    @Test
    void 유효하지_않은_입력일때_오류발생() {
        // Given
        String input = "abc\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // When/Then
        assertThatThrownBy(() -> inputView.readNumberInput())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NON_NUMERIC_STRING.getMessage());
    }

    @Test
    void 유효하지_않은_길이의_입력일때_오류발생() {
        // Given
        String input = "1234\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // When/Then
        assertThatThrownBy(() -> inputView.readNumberInput())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INPUT_LENGTH_IS_NOT_THREE.getMessage());
    }

    @Test
    void 유효한_FinishInput_일때_올바른_Enum을_반환() {
        // Given
        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // When
        FinishInput result = inputView.readFinishInput();

        // Then
        assertThat(result).isEqualTo(FinishInput.RESTART_GAME);
    }

    @Test
    void 유효하지_않은_FinishInput_일때_에러발생() {
        // Given
        String input = "3";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // When/Then
        assertThatThrownBy(() -> inputView.readFinishInput())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.FINISH_INPUT_IS_WRONG.getMessage());
    }

}
