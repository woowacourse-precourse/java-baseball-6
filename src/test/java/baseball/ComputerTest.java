package baseball;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
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
    void checkInputFormat() {
    }

    @Test
    void checkGuess() {
    }

    @Test
    void checkReplay() {
    }
}