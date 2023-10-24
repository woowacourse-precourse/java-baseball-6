package baseball;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BaseballComputerTest {
    private BaseballComputer baseballComputer;

    @BeforeEach
    public void setUp() {
        BaseballPrinter baseballPrinter = new BaseballPrinter();
        baseballComputer = new BaseballComputer(baseballPrinter);
    }

    @Test
    void play() {
    }

    @Test
    void 생성된_숫자는_서로_다른_정수_3자리이다() {
        //given
        //setUp()에서 실행 완료

        //when
        baseballComputer.generateNumber();

        //then
        //1. 3자리 값이다.
        List<Integer> generatedNumber = baseballComputer.getComputerNumber();
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
        baseballComputer.generateNumber();
        String validInput = "123";

        assertDoesNotThrow(() -> {
            //when
            List<Integer> guessNumber = baseballComputer.checkInputFormat(validInput);

            //then
            assertEquals(3, guessNumber.size());
        });
    }

    @Test
    void 자릿수가_3이_아닌_경우_예외를_던진다() {
        //given
        baseballComputer.generateNumber();
        String invalidInput = "1234";

        assertThrows(IllegalArgumentException.class, () -> {
            baseballComputer.checkInputFormat(invalidInput);
        });
    }

    @Test
    void 정수가_아닌_경우_예외를_던진다() {
        //given
        baseballComputer.generateNumber();
        String invalidInput = "ABC";

        assertThrows(IllegalArgumentException.class, () -> {
            baseballComputer.checkInputFormat(invalidInput);
        });
    }

    @Test
    void 같은_값이_있는_경우_예외를_던진다() {
        //given
        baseballComputer.generateNumber();
        String invalidInput = "112";

        assertThrows(IllegalArgumentException.class, () -> {
            baseballComputer.checkInputFormat(invalidInput);
        });
    }

    @Test
    void checkGuess() {
        List<Integer> guess = new ArrayList<>();
        guess.add(1);

    }

    @Test
    void 길이가_1이_아니면_에러_던짐() {
        String testError = "error";

        assertThrows(IllegalArgumentException.class, () -> {
            baseballComputer.checkReplay(testError);
        });
    }

    @Test
    void 길이가_1인_경우_확인하고_에러_던짐() {
        //given
        String testOne = "1";
        String testTwo = "2";
        String testThree = "3";

        //when
        boolean testOneResult = baseballComputer.checkReplay(testOne);
        boolean testTwoResult = baseballComputer.checkReplay(testTwo);

        //then
        assertEquals(testOneResult, true);
        assertEquals(testTwoResult, false);
        assertThrows(IllegalArgumentException.class, () -> {
            baseballComputer.checkReplay(testThree);
        });
    }
}