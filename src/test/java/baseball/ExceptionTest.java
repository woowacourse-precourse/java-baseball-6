package baseball;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.NotExtensible;

public class ExceptionTest {
    @Test
    void 유저입력예외처리테스트(){
        Display display = new Display();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            display.getSplitedUserInput("12 ");
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            display.getSplitedUserInput("12d");
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            display.getSplitedUserInput("122");
        });
    }
    @Test
    void 재시작입력예외처리테스트(){
        Display display = new Display();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            display.getSplitedUserInput(" 12");
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            display.getSplitedUserInput("d");
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            display.getSplitedUserInput("3");
        });
    }
}
