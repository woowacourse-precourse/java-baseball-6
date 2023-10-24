package baseball;

import static org.junit.jupiter.api.Assertions.assertEquals;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.Test;

public class UserInputHandlerTest extends NsTest {
    private UserInputHandler userInputHandler;

    @Test
    public void testReadUserInput() {
        String expectedInput = "123";
        InputStream inputStream = new ByteArrayInputStream(expectedInput.getBytes());
        System.setIn(inputStream);

        userInputHandler = new UserInputHandler();
        String userInput = userInputHandler.readUserInput();

        assertEquals(expectedInput, userInput);
    }


    @Test
    public void testParseStringNumbers() {
        userInputHandler = new UserInputHandler();
        String input = "123";
        List<Integer> userInputNumbers = userInputHandler.parseStringNumbers(input);

        assertEquals(3, userInputNumbers.size());
        assertEquals(1, (int) userInputNumbers.get(0));
        assertEquals(2, (int) userInputNumbers.get(1));
        assertEquals(3, (int) userInputNumbers.get(2));
    }

    @Override
    protected void runMain() {

    }
}