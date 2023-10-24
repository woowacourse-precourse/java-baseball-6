package baseball;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandTest {

    @Test
    void 사용자가_1을_누른경우_RETRY에_해당하는_객체를_반환한다() {
        assertEquals(Command.getCommand("1"), Command.RETRY);
    }

    @Test
    void 사용자가_2를_누른경우_EXIT에_해당하는_객체를_반환한다() {
        assertEquals(Command.getCommand("2"), Command.EXIT);
    }

    @Test
    void 사용자가_1_혹은_2가_아닌_다른_입력값을_제시한경우_IllegalArgumentException_예외를_반환한다() {
        assertThrows(IllegalArgumentException.class, () -> Command.getCommand("3"));
    }

    @Test
    void 입력값에_공백이_포함된경우_IllegalArgumentException_예외를_반환한다() {
        assertThrows(IllegalArgumentException.class, () -> Command.getCommand(" 1"));
    }
}