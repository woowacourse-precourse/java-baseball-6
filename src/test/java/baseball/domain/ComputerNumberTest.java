package baseball.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;

class ComputerNumberTest {

    @Test
    void 컴퓨터_랜덤_숫자_길이_확인() {
        List<Integer> computerNumber = new ComputerNumber().getComputerNumber();
        assertEquals(3, computerNumber.size());
    }

    @Test
    void 컴퓨터_랜덤_숫자_중복_확인() {
        int result = (int) new ComputerNumber().getComputerNumber().stream().distinct().count();
        assertEquals(3, result);
    }

    @Test
    void 컴퓨터_랜덤_숫자_범위_확인() {
        List<Integer> computerNumber = new ComputerNumber().getComputerNumber();
        assertTrue(computerNumber.stream().allMatch(num -> 1 <= num && num <= 9));
    }
}
