package baseball;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.NotExtensible;

import java.io.ByteArrayInputStream;

public class ExceptionTest {
    private final Display display = new Display();
    void inputStringToSystemIn(String data){
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
        display.close();
    }
    @Test
    void 유저입력예외처리테스트_길이가3이아닌입력(){
        inputStringToSystemIn("12 ");
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            display.getUserInput();
        });
    }
    @Test
    void 유저입력예외처리테스트_숫자가아닌입력(){
        inputStringToSystemIn("12d");
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            display.getUserInput();
        });
    }
    @Test
    void 재시작입력예외처리테스트_길이가1이아닌입력(){
        inputStringToSystemIn(" 12");
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            display.getRestartInput();
        });

    }
    @Test
    void 재시작입력예외처리테스트_숫자가아닌입력(){
        inputStringToSystemIn("d");
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            display.getRestartInput();
        });
    }
    @Test
    void 재시작입력예외처리테스트_1이나2가아닌입력(){
        inputStringToSystemIn("3");
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            display.getRestartInput();
        });
    }
}
