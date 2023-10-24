package baseball;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.Test;

class UserInterfaceTest {

    public static InputStream setReadLine(String readLine) {
        return new ByteArrayInputStream(readLine.getBytes());
    }

    @Test
    public void 숫자_입력_받기(){

        InputStream readLine = setReadLine("926");
        System.setIn(readLine);

        String expect = "926";
        String actual = UserInterface.requestUserInput();

        assertEquals(expect, actual);
    }
}