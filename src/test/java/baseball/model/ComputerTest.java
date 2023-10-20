package baseball.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComputerTest {
    private Computer computer;

    @BeforeEach
    public void setUp() {
        computer = new Computer();
    }

    @DisplayName("랜덤된 3자리 숫자를 초기화한다.")
    @Test
    public void generateRandomNumber() {
        //given
        int LIMIT_NUMBERS_SIZE = 3;

        //when
        computer.generateRandomNumber();

        //then
        assertEquals(LIMIT_NUMBERS_SIZE, computer.getRandomNumberList().size());
    }

    @DisplayName("랜덤된 3자리 숫자는 각각 1 ~ 9까지의 범위를 가진다.")
    @Test
    public void checkRangeRandomNumber() {
        //given
        int MIN_RANGE_NUMBER = 1;
        int MAX_RANGE_NUMBER = 9;

        //when
        computer.generateRandomNumber();

        //then
        for (int number : computer.getRandomNumberList()) {
            assertTrue(number >= MIN_RANGE_NUMBER && number <= MAX_RANGE_NUMBER);
        }
    }

}