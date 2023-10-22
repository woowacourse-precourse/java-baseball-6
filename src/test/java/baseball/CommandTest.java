package baseball;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandTest {

    @Test
    void 사용자가_1을_누른경우_RETRY에_해당하는_객체를_반환한다() {
        assertEquals(Command.getCommand("1"), Command.RETRY);
    }
}