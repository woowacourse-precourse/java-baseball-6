package baseball.view;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class InputViewTest {

    @Test
    public void inputNumber_ShouldReturnUserInput() {
        String userInput = "123";

        Mockito.framework().clearInlineMocks();

        Mockito.mockStatic(Console.class);
        when(Console.readLine()).thenReturn(userInput);

        String result = InputView.inputNumber();

        assertEquals(userInput, result);
    }

    @Test
    public void restartOrEndNumber_ShouldReturnUserInput() {
        String userInput = "2";

        Mockito.framework().clearInlineMocks();

        Mockito.mockStatic(Console.class);
        when(Console.readLine()).thenReturn(userInput);

        String result = InputView.restartOrEndNumber();

        assertEquals(userInput, result);
    }
}
