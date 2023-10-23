package baseball.viewTest;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.view.InputView;
import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputViewTest {
    private InputView inputView;

    @BeforeEach
    public void generateInputView() {
        inputView = new InputView();
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "345"})
    void 숫자입력_테스트(String num) {

        InputStream in = new ByteArrayInputStream(num.getBytes());
        System.setIn(in);

        String inputNum = inputView.inputNum();

        assertThat(inputNum).isEqualTo(num);
        Console.close();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2"})
    void 재시작_입력수_테스트(String restartNum) {

        InputStream in = new ByteArrayInputStream(restartNum.getBytes());
        System.setIn(in);

        String inputNum = inputView.restart();

        assertThat(inputNum).isEqualTo(restartNum);
        Console.close();
    }


}
