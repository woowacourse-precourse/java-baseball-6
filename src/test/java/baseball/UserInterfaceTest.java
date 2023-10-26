package baseball;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserInterfaceTest {

    private UserInputProvider userInterface;

    public static InputStream setReadLine(String readLine) {
        return new ByteArrayInputStream(readLine.getBytes());
    }

    @BeforeEach
    void given() {
        userInterface = new UserInputProvider();
    }

    @Test
    public void 숫자_입력_받기(){

        InputStream readLine = setReadLine("926");
        System.setIn(readLine);

        String expect = "926";
        String actual = userInterface.requestUserInput();

        assertEquals(expect, actual);
    }
}