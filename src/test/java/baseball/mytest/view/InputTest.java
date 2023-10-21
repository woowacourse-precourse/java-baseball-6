package baseball.mytest.view;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;


public class InputTest {

    @Test
    void 사용자에게서_숫자_입력_받기() {
        InputView inputView = new InputView();
        assertThat(inputView.getUserInput()).isEqualTo("123");
    }
}
