package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import baseball.enums.Constant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ComputerRandomNumbersTest {

    private ComputerRandomNumbers computerRandomNumbers;

    @BeforeEach
    void setUp() {
        computerRandomNumbers = new ComputerRandomNumbers();
    }

    @Test
    void 숫자개수_테스트() throws Exception {
        assertThat(Constant.MAX_NUMBER_LENGTH.getConstant()).isEqualTo(computerRandomNumbers.size());
    }

    @Test
    void 중복숫자여부_테스트() throws Exception {
        for (int i = 0; i < Constant.MAX_NUMBER_LENGTH.getConstant(); i++) {
            for (int j = i + 1; j < Constant.MAX_NUMBER_LENGTH.getConstant(); j++) {
                int number1 = computerRandomNumbers.get(i);
                int number2 = computerRandomNumbers.get(j);
                assertTrue(number1 != number2);
            }
        }
    }
}