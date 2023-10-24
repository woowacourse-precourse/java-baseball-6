package baseball;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ComputerTest {
    private Computer computer;

    @BeforeEach
    public void setUp() {
        Printer printer = new Printer();
        computer = new Computer(printer);
    }

    @Test
    void play() {
    }

    @Test
    void 생성된_숫자는_서로_다른_정수_3자리이다() {
        //given
        //setUp()에서 실행 완료

        //when
        computer.generateNumber();

        //then
        //1. 3자리 값이다.
        List<Integer> generatedNumber = computer.getComputerNumber();
        assertEquals(3, generatedNumber.size());

        //2. 각 자릿수는 1부터 9사이의 값이다.
        for (int number : generatedNumber) {
            assertTrue(number >= 1 && number <= 9);
        }

        //3. 각 자릿 수는 중복되지 않는 값이다.
        assertNotEquals(generatedNumber.get(0), generatedNumber.get(1));
        assertNotEquals(generatedNumber.get(0), generatedNumber.get(2));
        assertNotEquals(generatedNumber.get(1), generatedNumber.get(2));
    }

    @Test
    void 서로_다른_정수_3자리는_유효한_input이다() {
        //given
        computer.generateNumber();
        String validInput = "123";

        assertDoesNotThrow(() -> {
            //when
            List<Integer> guessNumber = computer.checkInputFormat(validInput);

            //then
            assertEquals(3, guessNumber.size());
        });
    }

    @Test
    void 자릿수가_3이_아닌_경우_예외를_던진다() {
        //given
        computer.generateNumber();
        String invalidInput = "1234";

        assertThrows(IllegalArgumentException.class, () -> {
            computer.checkInputFormat(invalidInput);
        });
    }

    @Test
    void 정수가_아닌_경우_예외를_던진다() {
        //given
        computer.generateNumber();
        String invalidInput = "ABC";

        assertThrows(IllegalArgumentException.class, () -> {
            computer.checkInputFormat(invalidInput);
        });
    }

    @Test
    void 같은_값이_있는_경우_예외를_던진다() {
        //given
        computer.generateNumber();
        String invalidInput = "112";

        assertThrows(IllegalArgumentException.class, () -> {
            computer.checkInputFormat(invalidInput);
        });
    }

    @Test
    void checkGuess() {
    }

    @Test
    void checkReplay() {
    }
}