package baseball;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.NotExtensible;

public class ExceptionTest {
    @Test
    void 유저입력예외처리테스트(){
        Display display = new Display();
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            display.getSplitedUserInput("12 ");
        });
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            display.getSplitedUserInput("12d");
        });

    }
    @Test
    void 재시작입력예외처리테스트(){
        Display display = new Display();
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            display.getSplitedUserInput(" 12");
        });
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            display.getSplitedUserInput("d");
        });
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            display.getSplitedUserInput("3");
        });
    }
}
