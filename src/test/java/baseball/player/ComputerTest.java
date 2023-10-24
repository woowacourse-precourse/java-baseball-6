package baseball.player;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import org.junit.jupiter.api.BeforeEach;

public class ComputerTest {
    static ByteArrayOutputStream outContent;
    static Field number;

    @BeforeEach
    void beforeEach() throws NoSuchFieldException, NoSuchMethodException {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        number = Computer.class.getDeclaredField("number");
        number.setAccessible(true);
    }
}
