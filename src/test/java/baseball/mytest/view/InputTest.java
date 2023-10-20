package baseball.mytest.view;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;


public class InputTest {

    @Test
    void 숫자_입력_받기(){
        InputView inputView = new InputView();
        assertThat(inputView.getUserInput()).isEqualTo("123");
    }
}
