package baseball.constant;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import org.junit.jupiter.api.Test;

public class CommandTest {
    @Test
    void RESTART_Command_리턴() {
        // given
        String strCmd = "1";

        // when
        Command restartCmd = Command.RESTART;

        // then
        assertAll(
                () -> assertInstanceOf(Command.class, Command.of(strCmd)),
                () -> assertEquals(restartCmd, Command.of(strCmd))
        );
    }

    @Test
    void QUIT_Command_리턴() {
        // given
        String strCmd = "2";

        // when
        Command quitCmd = Command.QUIT;

        // then
        assertAll(
                () -> assertInstanceOf(Command.class, Command.of(strCmd)),
                () -> assertEquals(quitCmd, Command.of(strCmd))
        );
    }
}
