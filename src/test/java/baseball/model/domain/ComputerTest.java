package baseball.model.domain;

import static baseball.model.constants.Constant.NUMBER_SIZE;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComputerTest {
    @Test
    @DisplayName("상대방의 역할인 컴퓨터가 1부터 9까지 서로 다른 수로 이루어진 3자리의 랜덤 수를 리턴합니다.")
    void 세자리랜덤수리턴() {
        Computer computer = new Computer();

        List<Integer> randomNumbers = computer.getNumbers();

        assertEquals(NUMBER_SIZE, randomNumbers.size());
    }
}