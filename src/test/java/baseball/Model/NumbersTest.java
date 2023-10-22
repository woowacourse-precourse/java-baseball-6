package baseball.Model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumbersTest {

    Numbers computerNumbers = new Numbers(List.of(1,2,3));;
    Numbers userNumbers = new Numbers(List.of(4,2,1));

    @Test
    @DisplayName("같은숫자 찾기 테스트")
    public void countSameNumberTest() {
        assertEquals(userNumbers.countSameNumber(computerNumbers), 2);
    }

    @Test
    @DisplayName("같은 위치의 같은 숫자 찾기 테스트")
    public void countSameIndexAndNumberTest() {
        assertEquals(userNumbers.countSameIndexAndNumber(computerNumbers), 1);
    }
}
