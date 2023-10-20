package baseball.model;

import static baseball.util.NumberConstants.LIMIT_NUMBERS_SIZE;
import static baseball.util.NumberConstants.MAX_RANGE_NUMBER;
import static baseball.util.NumberConstants.MIN_RANGE_NUMBER;
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
        int size = LIMIT_NUMBERS_SIZE.getValue();

        //when
        computer.generateRandomNumber();

        //then
        assertEquals(size, computer.getRandomNumberList().size());
    }

    @DisplayName("랜덤된 3자리 숫자는 각각 1 ~ 9까지의 범위를 가진다.")
    @Test
    public void checkRangeRandomNumber() {
        //given
        int minRangeValue = MIN_RANGE_NUMBER.getValue();
        int maxRangeValue = MAX_RANGE_NUMBER.getValue();

        //when
        computer.generateRandomNumber();

        //then
        for (int number : computer.getRandomNumberList()) {
            assertTrue(number >= minRangeValue && number <= maxRangeValue);
        }
    }

}