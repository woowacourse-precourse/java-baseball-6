package baseball.player;

import static org.junit.jupiter.api.Assertions.assertThrows;

import baseball.util.Number;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @Test
    @DisplayName("세 자리 숫자가 아닐 경우 IllegalArgumentException을 반환한다.")
    public void 세자리_숫자가_아닐_경우_IllegalArgumentException을_반환한다() throws IllegalAccessException {
        // given
        Computer computer = new Computer();
        Number testNumber = new Number(1234);
        number.set(computer, testNumber);

        // when & then
        assertThrows(IllegalArgumentException.class, () -> computer.validateNumber());
    }

    @Test
    @DisplayName("음수일 경우 IllegalArgumentException을 반환한다.")
    public void 음수일_경우_IllegalArgumentException을_반환한다() throws IllegalAccessException {
        // given
        Computer computer = new Computer();
        Number testNumber = new Number(-123);
        number.set(computer, testNumber);

        // when & then
        assertThrows(IllegalArgumentException.class, () -> computer.validateNumber());
    }
}
