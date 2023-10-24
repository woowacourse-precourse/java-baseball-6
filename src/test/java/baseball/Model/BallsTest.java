package baseball.Model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BallsTest {

    Balls computerBalls = new Balls(List.of(1,2,3));;
    Balls userBalls = new Balls(List.of(4,2,1));

    @Test
    @DisplayName("같은숫자 찾기 테스트")
    public void countSameNumberTest() {
        assertEquals(userBalls.countSameNumber(computerBalls), 2);
    }

    @Test
    @DisplayName("같은 위치의 같은 숫자 찾기 테스트")
    public void countSameIndexAndNumberTest() {
        assertEquals(userBalls.countSameIndexAndNumber(computerBalls), 1);
    }
}
