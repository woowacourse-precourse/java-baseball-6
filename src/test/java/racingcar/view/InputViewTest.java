package racingcar.view;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputViewTest {
    InputView inputView;
    @BeforeEach
    public void setUp() {
        inputView = new InputView();
    }
    @Test
    public void 자동차_이름_입력_예외_테스트() {
        String emptyInput = "";
        assertThatThrownBy(() -> inputView.validateCarNames(emptyInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 횟수_입력_예외_테스트() {
        String numericInput = "d";
        assertThatThrownBy(() -> inputView.validateAttempts(numericInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
