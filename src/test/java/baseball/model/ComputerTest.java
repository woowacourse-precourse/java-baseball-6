package baseball.model;

import static baseball.util.NumberConstants.LIMIT_NUMBERS_SIZE;
import static baseball.util.NumberConstants.MAX_RANGE_NUMBER;
import static baseball.util.NumberConstants.MIN_RANGE_NUMBER;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
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

    @DisplayName("랜덤으로 초기화된 숫자는 중복된 값을 가지지 않고 유니크하다.")
    @Test
    public void checkUniquNumber() {
        //when
        computer.generateRandomNumber();
        List<Integer> randomNumberList = computer.getRandomNumberList();

        //then
        assertTrue(isUniqueNumber(randomNumberList));
    }

    private boolean isUniqueNumber(List<Integer> randomNumberList) {
        for (int i = 0; i < randomNumberList.size(); i++) {
            for (int j = i + 1; j < randomNumberList.size(); j++) {
                if (randomNumberList.get(i).equals(randomNumberList.get(j))) {
                    return false;
                }
            }
        }
        return true;
    }
}