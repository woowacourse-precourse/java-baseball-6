package baseball.player;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import org.junit.jupiter.api.BeforeEach;

public class UserTest {
    static ByteArrayOutputStream outContent;
    static Field number;

    @BeforeEach
    void beforeEach() throws NoSuchFieldException {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        number = User.class.getDeclaredField("number");
        number.setAccessible(true);
    }

}
