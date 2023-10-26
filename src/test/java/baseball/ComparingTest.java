package baseball;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComparingTest {
    private Comparing comparing;
    private List<Integer> givenComputer;

    @BeforeEach
    public void given() {
        comparing = new Comparing();
        givenComputer = Arrays.asList(1, 2, 3);
    }

    @Test
    @DisplayName("3 스트라이크 테스트")
    public void testThreeStrike(){
        //given
        int expect = 3;
        Result result = comparing.compareNumbers("123", givenComputer);

        //then
        assertEquals(expect, result.getStrike());
    }


    @Test
    @DisplayName("3 볼 테스트")
    public void testThreeBall(){
        //given
        int expect = 3;
        Result result = comparing.compareNumbers("231", givenComputer);

        //then
        assertEquals(expect, result.getBall());
    }
    @Test
    @DisplayName("3 볼 테스트 엣지 케이스 검토")
    public void testThreeBallEdge(){
        //given
        int expect = 3;
        Result resultThree = comparing.compareNumbers("312", givenComputer);

        //then
        assertEquals(expect, resultThree.getBall());
    }

}